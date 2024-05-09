package org.example.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoThreadServer {

    public static void main(String[] args) {

        // 1. ServerSocket 생성 => 1개만
        try(ServerSocket serverSocket = new ServerSocket(9999);
        ) {
            while(true) {

                Socket clientsocket = serverSocket.accept(); // 클라이언트 수 만큼 반복되야 여러개 받을 수 있음

                // 클라이언트마다 각자 실행 할 수 있도록 만들어야 함 => 쓰레드 클래스 생성하러.. (2)
                EchoThread echothread = new EchoThread(clientsocket);
                echothread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 2. 클라이언트마다 각자 실행 할 수 있도록 만들어야 함 => 쓰레드 클래스 생성
class EchoThread extends Thread {
    private Socket socket;
    EchoThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println(socket.getInetAddress().getHostName() + "로부터 연결 완료");

        try(PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ){

            String inputLine;
            while((inputLine = in.readLine()) != null) {
                System.out.println("echo: " + inputLine);
                out.println(inputLine);
            }

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
