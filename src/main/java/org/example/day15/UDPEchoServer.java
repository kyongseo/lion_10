package org.example.day15;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPEchoServer {

    public static void main(String[] args) {

        //1. UDP 통신 특정 port에 생성
        try (DatagramSocket datagramSocket = new DatagramSocket(8888);){
            while (true) {
                byte[] receiveDate = new byte[1024];
                byte[] sendDate;

                DatagramPacket receivePacket = new DatagramPacket(receiveDate, receiveDate.length);
                datagramSocket.receive(receivePacket);

                String msg = new String(receivePacket.getData());

                // 클라이언트의 정보
                InetAddress clientAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                // 클라이언트에게 데이터를 보냄
                sendDate = msg.getBytes(StandardCharsets.UTF_8);

                DatagramPacket sendPacket = new DatagramPacket(sendDate, sendDate.length, clientAddress, port);
                datagramSocket.send(sendPacket);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
