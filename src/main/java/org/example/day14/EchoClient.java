package org.example.day14;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
    public static void main(String[] args) {
        System.out.println("클라이언트가 준비되었습니다.");
        String hostName = "127.0.0.1"; // 서버의 호스트 이름 또는 IP 주소
        int portNumber = 12345; // 서버 포트 번호
        try (Socket echoSocket = new Socket(hostName, portNumber);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true); // 서버
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

             // 키보드로부터 받아지는 것도 호츌
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                if ("exit".equalsIgnoreCase(userInput.trim())) {
                    System.out.println("메시지 전송을 종료합니다.");
                    break;
                }
                out.println(userInput); // 서버에 메시지 전송
                System.out.println("echo: " + in.readLine()); // 서버로부터의 응답 출력 => 서버의 out이 클라이언트의 in이 됨
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }
}