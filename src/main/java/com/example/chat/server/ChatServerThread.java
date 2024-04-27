package com.example.chat.server;

import java.io.*;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.Map.*;

class ChatServerThread extends Thread {

    private Socket socket;
    private String id;
    private Map<String, PrintWriter> clients;   // 클라이언트 메시지
    private Map<String, Integer> userRooms; // 클라이언트의 방

    private BufferedReader br;
    private PrintWriter pw;

    private static AtomicInteger nextRoomNumber = new AtomicInteger(1);

    public static int getNextRoomNumber() {
        return nextRoomNumber.getAndIncrement();
    }

    public ChatServerThread(Socket socket, Map<String, PrintWriter> clients, Map<String, Integer> userRooms) {
        this.socket = socket;
        this.clients = clients;
        this.userRooms = userRooms;

        try {
            pw = new PrintWriter(socket.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            pw.println("방 목록 보기 : /list");
            pw.println("방 생성 : /create");
            pw.println("방 입장 : /join [방번호]");
            pw.println("방 나가기 : /exit");
            pw.println("접속 종료 : /bye");

            while (true) {
                // 클라이언트가 접속 시 id 설정
                id = br.readLine();

                // id가 이미 있는 경우
                if (clients.containsKey(id))
                    pw.println("이미 존재하는 닉네임입니다. 다시 입력해주세요.");
                break;
            }

            // 접속 시 클라이언트의 정보 출력
            // [id] /port 번호 형태로 출력됨
            System.out.println("[" + id + "]" + socket.getInetAddress() + "." + socket.getPort() + " 님이 입장했습니다.");
            int size = clients.size() + 1;
            System.out.println("현재 서버의 접속자는 " + size + "명 입니다.");

            // 동시에 입장하는 경우 고려
            synchronized (clients) {
                clients.put(this.id, pw);
                userRooms.put(this.id, 0);    // 처음에 입장 시 방번호 0번
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        String msg;
        try {
            while ((msg = br.readLine()) != null) {
                // 접속 종료
                if ("/bye".equalsIgnoreCase(msg)) {
                    pw.println("접속을 종료합니다.");
                    break;
                }

                // 방 목록 보기
                if ("/list".equalsIgnoreCase(msg)) {
                    listRooms();
                }

                // 방 생성
                else if ("/create".equalsIgnoreCase(msg)) {
                    synchronized (userRooms) {
                        int room = getNextRoomNumber();
                        userRooms.put(this.id, room);
                        enterRoom(room);
                        pw.println(room + "번 방이 생성되었습니다.");
                    }
                }

                // 방 참가
                else if (msg.startsWith("/join")) {
                    String[] parts = msg.split(" ");
                    if (parts.length < 2) {
                        pw.println("방 번호를 입력하세요. 예: /join [방번호]");
                        continue;
                    }
                    try {
                        int roomNum = Integer.parseInt(parts[1]);
                        joinRoom(roomNum);
                    } catch (NumberFormatException e) {
                        pw.println("올바른 방 번호를 입력하세요. 예: /join [방번호]");
                    }
                }

                // 방 나가기
                else if ("/exit".equalsIgnoreCase(msg)) {
                    exitRoom();
                }

                // 방에 참가된 경우 메시지 주고 받기 가능
                else {
                    sendMessage(msg);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            // 동시에 종료하는 경우 고려
            synchronized (clients) {
                clients.remove(id);
            }

            System.out.println("[" + id + "]" + socket.getInetAddress() + "." + socket.getPort() + " 님이 나가셨습니다.");
            int size = clients.size() ;
            System.out.println("현재 서버의 접속자 수는 " + size + "명 입니다.");

            // 사용 후 BufferedReader와 Socket 닫기
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // 방의 리스트 보기
    public void listRooms() {
        synchronized (userRooms) {
            // 방 목록
            Map<String, Integer> existRooms = userRooms.entrySet().stream()
                    .filter(entry -> entry.getValue() != 0)  // 방 번호가 0이 아닌 것만 필터링
                    .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

            // 방 목록이 비어있는지 확인하여 메시지 전송
            if (existRooms.isEmpty()) {
                pw.println("방이 없습니다. 방을 생성하려면 /create를 입력하세요.");
            } else {
                pw.println("방 목록: ");

                existRooms.forEach((roomNumber, roomName) -> pw.print(roomName + " "));
                pw.println();
            }
        }
    }

    // 방 참가
    public void joinRoom(int roomNum) {
        synchronized (userRooms) {
            // 해당 방 번호가 존재하는지 확인
            if (userRooms.values().contains(roomNum)) {
                int currentRoom = userRooms.get(this.id);

                // 이미 해당 방에 입장한 상태인지 확인
                if (currentRoom == roomNum) {
                    pw.println("이미 해당 방에 입장하셨습니다.");
                    return;
                }

                // 다른 방으로 이동하기 전에 현재 방을 나가기
                if (currentRoom != 0) {
                    exitRoom();
                }

                // 사용자의 방 정보 변경
                userRooms.put(this.id, roomNum);

                // 새로 입장한 방에 메시지 전달
                enterRoom(roomNum);
            } else {
                pw.println("해당하는 방 번호가 존재하지 않습니다.");
            }
        }
    }

    // join 해서 들어온 경우
    public void enterRoom(int room) {
        sendMessageToRoom(room, id + "님이 입장하였습니다.");

        int size = clients.size() ;
        sendMessageToRoom(room  ,"현재 " + room + "번 방의 인원수는 " + size +"명 입니다.");
    }

    // 방 나가기
    public void exitRoom() {
        int currentRoom = userRooms.get(this.id);
        userRooms.put(this.id, 0); // 사용자의 방 번호를 0으로 설정
        pw.println("방을 퇴장하였습니다.");

        synchronized (clients) {
            // 해당 방에 남아있는 사용자가 있는지 확인
            boolean isRoomEmpty = userRooms.values().stream()
                    .noneMatch(room -> room == currentRoom);

            // 비었으면 방 삭제
            if (isRoomEmpty) {
                System.out.println(currentRoom + "번 방이 삭제되었습니다.");
            } else {
                // 방에 남아있는 사용자에게 메시지 전송
                sendMessageToRoom(currentRoom, id + "님이 퇴장했습니다.");
            }
        }
    }

    // 해당 방을 사용하는 사람에게 입장/퇴장 메시지 전송
    public void sendMessageToRoom(int room, String message) {
        synchronized (clients) {
            clients.forEach((clientId, clientPw) -> {
                if (userRooms.get(clientId).equals(room)) {
                    try {
                        clientPw.println(message);
                    } catch (Exception e) {
                        clients.remove(clientId);
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    // 메시지 보내기
    public void sendMessage(String msg) {
        int currentRoom = userRooms.get(this.id); // 현재 클라이언트의 방 번호

        synchronized (clients) {
            // 현재 클라이언트와 같은 방에 있는 클라이언트에게만 메시지 전송
            clients.forEach((clientId, clientPw) -> {
                int clientRoom = userRooms.get(clientId);
                if (clientRoom == currentRoom && !clientId.equals(this.id)) {
                    try {
                        clientPw.println("[" + id + "] " + msg);
                    } catch (Exception e) {
                        clients.remove(clientId);
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}