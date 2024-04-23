package org.example.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        // 아이디가 처음에 입력되게 하기 위해서 args[0] 에서 받아오는 것으로 구현해봅시다
        if (args.length != 1) {
            System.out.println("사용법 : java ChatClient id");
            System.exit(1);
        }

        try(Socket socket = new Socket("127.0.0.1", 9999);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {

            // 접속되면 id를 서버로 보낸다. 서버와의 약속
            out.println(args[0]);

            // 입력을 담당하는 부분을 쓰레드로
            new InputThread(socket, in).start();

            // 서버로부터 받은 메시지를 출력하는 부분을 별도의 스레드로 분리
          //  new OutputThread(out).start();
            //new OutputThread(in).start();

            // 키보드로부터 입력받은 내용을 서버에 보내는 코드
            String msg = null;
            while ((msg = keyboard.readLine()) != null) {
                out.println(msg);
                if ("/quit".equalsIgnoreCase(msg)) {
                    break;
                }
            }

        }catch (Exception e) {
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
            System.out.println("서버와의 연결이 종료되었습니다.");

        } finally {
            if (socket != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    System.out.println("입력 스트림을 닫는 동안 오류가 발생했습니다.");
                    e.printStackTrace();
                }
            }
        }
    }
}
