package org.example.day14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerExam {
    public static void main(String[] args) throws IOException {

        // 1. ServerSocket 생성
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("서버가 준비되었습니다.");

        // 2. 클라이언트 연결 수락
        Socket socket = serverSocket.accept(); // 클라이언트 소켓 얻어옴
        System.out.println(socket.getInetAddress().getHostAddress() + "로 부터 연결되었습니다.");

        // 3. 데이터를 읽고 쓰기
        // 입력통로 socket.getInputStream();
        // 클라이언트의 출력이 서버의 입력이 된다.
        // InputStream in = socket.getInputStream(); // 서버의 입력

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//         BufferedReader br = new BufferedReader(new InputStreamReader(in));

        // 출력통로 socket.getOutputStream();
        // OutputStream out = socket.getOutputStream(); // 클라리언트의 출력
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//         PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

        String line = null;

        while ((line = br.readLine()) != null) {
            System.out.println("클라이언트로부터 받은 메시지 : " + line);

            // 클라이언트가 보낸 메시지를 그대로 다시 클라이언트에게 보낸다.
            pw.println(line);
            pw.flush();
        }

        pw.close();
    }
}
