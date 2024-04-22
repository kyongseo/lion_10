package org.example.day14;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NsLockupLocal {

    public static void main(String[] args) {

        try {
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("local Host Name  : " + localAddress.getHostName());
            System.out.println("local Address    : " + localAddress.getHostAddress());

            System.out.println("byte[] 형식의 ip 주소 변환 ");
            byte[] ip = localAddress.getAddress();
            for (int i = 0; i < ip.length; i++) {
                System.out.print(ip[i] & 0xFF);
                if (i != ip.length -1)
                    System.out.print(".");
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        System.out.println("\n========================================");

        try {
            InetAddress address = InetAddress.getByName("www.naver.com");
            System.out.println(address.getHostAddress());

            InetAddress local = InetAddress.getLocalHost();
            System.out.println("Local Host Name  : " + local.getHostAddress());
            System.out.println("Local IP Address : " + local.getHostAddress());

        }catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
