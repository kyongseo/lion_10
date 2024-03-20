package org.example.ch01.Algorithm;

import java.util.Scanner;

public class TwoDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("값 입력");
            n = sc.nextInt();
        } while (n < 10 || n > 99);

        System.out.println("입력한 두 자리의 정수 값은 " + n + "입니다.");
    }
}
