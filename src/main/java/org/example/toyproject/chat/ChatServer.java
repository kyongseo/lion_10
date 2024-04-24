package org.example.toyproject.chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    public static void main(String[] args) {
        // 1. 서버 소켓 설정 및 공유 객체 정의
        try (ServerSocket serverSocket = new ServerSocket(9999);) {
            System.out.println("서버가 준비되었습니다.");
            Map<String, PrintWriter> chatClients = new HashMap<>();

            while (true) {
                // 4. 어떤 클라이언트가 연결을 시도하면 수락
                Socket socket = serverSocket.accept();
                // 5. 쓰레드 호출
                new ChatThread(socket, chatClients).start();
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}

class ChatThread extends Thread {
    private Socket socket;
    private String id;
    private Map<String, PrintWriter> chatClients;

    private BufferedReader in;
    PrintWriter out;

    // 6. 쓰레드가 호출되면 동시에 생성자 실행
    public ChatThread(Socket socket, Map<String, PrintWriter> chatClients) {
        this.socket = socket;
        this.chatClients = chatClients;

        try {
            // 8. 클라이언트에게 id를 입력받고, broadcast를 통해 현재 연결되어 있는 클라이언트에게 입장 알림을 보내주고, 서버에 새로운 id를 출력한다.
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            id = in.readLine();
            broadcast(id + "님이 입장하셨습니다.");
            System.out.println("새로운 사용자의 아이디는 " + id + "입니다.");

            // 9. chatClients.put(this.id, out)를 실행할 때
            // synchronized를 이용해 chatClients에 다른 쓰레드가 접근할 수 없게 해준다.
            synchronized (chatClients) {
                chatClients.put(this.id, out);
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // 해당 클라이언트의 채팅이 시작됐다는 알림을 서버에게 전송하고,
        // 클라이언트가 /quit를 입력하기 전까지 입력하는 값들은 전부 모든 클라이언트에게 전송해준다.
        // 종료될 때까지 반복
        System.out.println(id + "사용자 채팅시작!!");
        String msg = null;
        try {
            while ((msg = in.readLine()) != null) {
                if ("/quit".equalsIgnoreCase(msg))  break;

//                if(msg.split(" ").length == 3 && "/to".equalsIgnoreCase(msg.split(" ")[0])){
                if("/to".equalsIgnoreCase(msg.split(" ")[0])){
                    sendMsg(id, msg.split(" ")[1], msg.split(" ")[2]);
                } else{
                    broadcast(id + " : " + msg);
                }
            }

        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
            // 해당 클라이언트가 /quit를 눌러 입력이 종료되면, 그 클라이언트를 공유객체에서 제거해주고,
            // 모든 클라이언트에게 해당 클라이언트가 나갔다는 알림을 전송한다.
        } finally {
            synchronized (chatClients) {
                chatClients.remove(id);
            }
            broadcast(id + "님이 채팅에서 나갔습니다.");

            if (in != null) {
                try {
                    in.close();
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


    public void broadcast(String msg) {
        // broadcast에서 chatClients에 접근하는 동안엔 chatClients에 클라이언트 추가/제거가 불가하게 설정
        synchronized (chatClients) {
            // chatClients의 value값들을 저장한 it 객체 생성 즉, 연결된 모든 클라이언트가 저장됨
            Iterator<PrintWriter> it = chatClients.values().iterator();

            while (it.hasNext()) {
                // 해당 클라이언트로 전송하는 out 객체 받아주기
                PrintWriter out = it.next();
                try {
                    // 해당 클라이언트에게 전송
                    out.println(msg);
                } catch (Exception e) {
                    // 뭔가 오류가 나면 해당 객체 삭제(chatClients에서도 삭제)
                    it.remove();
                    e.printStackTrace();
                }
            }
        }
    }

    public void sendMsg(String fromId, String toId, String msg) {
        synchronized (chatClients) {
            if(chatClients.containsKey(toId)){
                chatClients.get(toId).println(fromId + "님이 " + toId + "님에게 보낸 메시지: " + msg);
            } else{
                chatClients.get(fromId).println("해당 사용자가 존재하지 않습니다.");
            }
        }
    }
}