package org.example.toyproject.chat;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        // 2. id 입력하지 않았다면 클라이언트 연결하지 않고 프로세스 종료
        if (args.length != 1) {
            System.out.println("사용법 : java ChatClent id");
            System.exit(1);
        }

        // 3. 서버 소켓과 동일한 포트로 연결하고, 입력 출력 객체 생성
        try (Socket socket = new Socket("127.0.0.1", 9999);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        ) {

            // 7. 서버에게 id 전송
            out.println(args[0]);

            // 8. 쓰레드 시작
            new InputThread(socket, in).start();

            // 9. 클라이언트가 서버에게 입력값 전달(종료할 때까지 반복)
            String msg = null;
            while ((msg = keyboard.readLine()) != null) {
                out.println(msg);
                if ("/quit".equalsIgnoreCase(msg))
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class InputThread extends Thread {
    private Socket socket;
    private BufferedReader in;

    InputThread(Socket socket, BufferedReader in) {
        this.socket = socket;
        this.in = in;
    }

    @Override
    public void run() {
        try {
            String msg = null;
            while ((msg = in.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}