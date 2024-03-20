package org.example.ch01.Algorithm;

import java.util.Scanner;

public class SumFor2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("1부터 n까지의 총합을 구하는 프로그램입니다.");

        do {
            System.out.print("양의 정수 n을 입력해주세요: ");
            n = sc.nextInt();

        } while (n <= 0); // 양수가 입력될 때까지 반복 요청

        int sum = 0; // 총합을 저장할 변수 초기화

        for (int i = 1; i <= n; i++)
            sum += i; // i 값을 총합에 추가

        System.out.println("1부터 " + n + "까지의 총합은 " + sum + "입니다.");
    }
}
