package org.example.day15;

import java.net.*;
import java.util.Scanner;

public class UDPEchoClient {
    public static void main(String[] args) throws Exception {

        try(DatagramSocket clientSocket = new DatagramSocket();
            // 키보드로 입력받기
            Scanner scanner = new Scanner(System.in);){

            // 서버의 주소 설정
            InetAddress ipAddress = InetAddress.getByName("localhost");
            byte[] receiveData = new byte[1024];
            byte[] sendData;


            System.out.print("enter : ");
            String input = scanner.nextLine();

            // 서버로 보내기
            sendData = input.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, 12345);
            clientSocket.send(sendPacket);

            // 서버로부터 받기
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String modifiedString = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println(modifiedString);

            clientSocket.close();

        }catch (Exception e) {

            e.printStackTrace();
        }
    }
}
