package org.example.ch01.Algorithm;

import java.util.Scanner;

public class TriangleLB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        do {
            System.out.printf("양수 입력 >> ");
            n = sc.nextInt();
        } while (n <= 0);

        for (int i =1; i<=n; i++){
            for (int j =1; j<=i; j++){
                System.out.println("왼족부터 채워지는 삼각형을 출력");
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
