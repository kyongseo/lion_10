package org.example.day14;

import java.io.*;
import java.net.Socket;

public class EchoClientExam {

    public static void main(String[] args) throws IOException {
        // 1. Socket 생성
        Socket socket = new Socket("127.0.0.1", 9999); // 서버와 연결되어 있는 소켓
        System.out.println(9999 + " 포트와 잘 연결되었습니다.");

        // 2. 데이터 읽고 쓰기
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream())); // 클라이언트의 출력값 = > 출력 값이 서버의 입력 값이 될 것

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트의 입력 값 => 입력값이 서버의 출력 값이 됨

        // 3. 클라이언트가 키보드를 통해 입력하기 위한 통로
        BufferedReader keybord = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        while ((line = keybord.readLine()) != null) {
            if (line.equalsIgnoreCase("quit")) {
                break;
            }
            // 서버에게 보냄
            pw.println(line);
            pw.flush();

            // 서버에서 받음
            String echo = br.readLine();
            System.out.println("서버로부터 받은 응답 메시지 : " + echo);
        }

        // 4. 연결 종료
        pw.close();
        br.close();
        keybord.close();
        socket.close();
    }
}
