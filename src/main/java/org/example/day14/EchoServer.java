package org.example.day14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        System.out.println("서버가 준비되었습니다.");

        try (ServerSocket serverSocket = new ServerSocket(9999);
             Socket socket = serverSocket.accept();
             // 출력
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // true 를 지정해주면 flush() 를 자동으로 해줌

             // 입력
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));){

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("받은 메시지 : " +inputLine);

                out.println(inputLine);

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf(e.getMessage());
        }
    }
}
