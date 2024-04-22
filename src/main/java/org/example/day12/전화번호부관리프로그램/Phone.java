package org.example.day12.전화번호부관리프로그램;

import java.io.*;
import java.util.Scanner;

public class Phone {
    public static void main(String[] args) {

        try(PrintWriter pw = new PrintWriter(new FileOutputStream("src/main/java/org/example/day12/phone.txt"));){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//            Scanner sc = new Scanner(System.in);
//            System.out.print("몇명의 연락처를 추가할까요. : ");
//            int n = sc.nextInt();

            for (int i = 0; i < 3 ; i++) {
                System.out.print("이름 : ");
                String name = br.readLine();
                System.out.print("전화번호 : ");
                String phoneNumber = br.readLine();

                pw.println(name + " " + phoneNumber);
        }
            pw.close();
            System.out.println("phone.txt에 추가되었습니다.");

            System.out.println("===================================================");

            String phoneList; // list 정의
            BufferedReader br2 = new BufferedReader(new FileReader("src/main/java/org/example/day12/phone.txt"));
            System.out.println("phone.txt 내용을 읽어옵니다.");

            while ((phoneList = br2.readLine()) != null) {
                System.out.println(phoneList);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일 읽기 오류");
        }
    }
}
