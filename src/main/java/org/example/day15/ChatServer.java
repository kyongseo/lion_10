package org.example.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChatServer {
    public static void main(String[] args) {
        // 1. 서버소켓 생성
        try (ServerSocket serverSocket = new ServerSocket(9999);) { // 9999 포트를 사용하여 새로운 서버 소켓을 생성
            System.out.println("서버 연결 완료"); // 서버가 준비되었다는 메시지를 출력
            // 여러명의 클라이언트의 정보를 기억할 공간
            // 클라이언트의 아이디를 키로, 출력 스트림을 값으로 갖는 해시맵을 생성. 각 클라이언트의 정보를 이 해시맵에 저장하여 관리
            Map<String, PrintWriter> chatClients = new HashMap<>(); // => 아이디에 따라 다른일을 하고 싶어서 맵 선택 // 리스트나 셋도 가능?

            while (true) {
                // 2. accept() 를 통해서 소켓을 얻어옴  (여러명의 클라이언트와 접속할 수 있도록 구현)
                Socket socket = serverSocket.accept(); // 클라이언트의 연결 요청을 받아들이고, 새로운 클라이언트와 통신할 소켓을 생성
                // Thread 이용
                // 여러명의 클라이언트의 정보를 기억할 공간

                new ChatThread(socket, chatClients).start(); // 채팅을 처리하는 스레드 시작. 이 스레드는 각 클라이언트와의 통신 담당

            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}

class ChatThread extends Thread {
    // 생성자를 통해서 클라이언트 소켓을 얻어옴
    private Socket socket; // 클라이언트와의 통신을 위한 소켓
    private String id; // 클라이언트의 아이디를 저장하는 변수
    private Map<String, PrintWriter> chatClients; // 다른 클라이언트들의 정보를 갖고 있음

    private BufferedReader in;
    PrintWriter out; // 클라이언트로 메시지를 보내기 위한 출력 스트림


    public ChatThread(Socket socket, Map<String, PrintWriter> chatClients) {
        this.socket = socket;
        this.chatClients = chatClients;

        // 클라이언트가 생성될 때 클라이언트로 부터 아이디를 얻어오게 하고 싶다? => 각각 클라이언트와 통신 할 수 있는 통로얻어옴
        // 클라이언트와의 통신을 위한 출력 스트림 생성. true는 자동으로 flush를 수행하도록 설정
        try {
            // 클라이언트로 메시지를 보내기 위한 출력 스트림 생성
            out = new PrintWriter(socket.getOutputStream(), true);
            // 클라이언트로부터 메시지를 읽어들이기 위한 입력 스트림을 생성
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // client 가 접속하자마자 id를 보낸다는 약속
            // 클라이언트로부터 아이디를 읽어
            id = in.readLine();
            //이때 모든 사용자에게 id님이 입장했다라는 정보를 알려줌.
            broadcast(id + "님이 입장하셨습니다.");
            System.out.println("새로운 사용자의 아이디는 " + id + "입니다.");

            // 동시에 일어날 수도 있으므로, 동기화
            synchronized (chatClients) {
                // 클라이언트의 아이디와 출력 스트림을 해시맵에 저장
                chatClients.put(this.id, out);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        System.out.println(id + "사용자 채팅 시작");
        // run
        // 연결된 클라이언트가 메시지를 전송하면, 그 메시지를 받아서 다른 사용자들에게 보내줌..
        String msg = null;
        try {

            while ((msg = in.readLine()) != null) {
                // 채팅 중 /quit을 입력하면 채팅이 종료되고 클라이언트가 채팅에서 나갔다는 메시지가 전체 클라이언트에게 전송
                if ("/quit".equalsIgnoreCase(msg))
                    break;
                // 클라이언트의 메시지를 모든 클라이언트에게 전송
                broadcast(id + " : " + msg);
            }

        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();

        } finally {
            // 클라이언트가 채팅에서 나갔을 때, 해당 클라이언트의 정보를 해시맵에서 삭제하고, 모든 클라이언트에게 알림
            synchronized (chatClients) {
                chatClients.remove(id);
            }
            broadcast(id + "님이 채팅에서 나갔습니다.");

            // 소켓 및 입력 스트림 닫기
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

//    //전체 사용자에게 알려주는 메서드
//    public void broadcast(String msg) {
//        for (PrintWriter out : chatClients.values()) {
//            out.println(msg);
//        }
//    }

    public void broadcast(String msg) {
        Iterator<PrintWriter> it = chatClients.values().iterator();
        while (it.hasNext()) {
            PrintWriter pw = it.next();
            try {
                pw.println(msg);
            } catch (Exception e) {
                it.remove(); // 브로드캐스트 할 수 없는 사용자를 제거
                e.printStackTrace();
            }
        }
    }
}

