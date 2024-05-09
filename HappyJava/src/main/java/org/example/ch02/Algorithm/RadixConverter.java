package org.example.ch02.Algorithm;

import java.util.Scanner;

public class RadixConverter {
    static int convertToRadix(int x, int radix, char[] d) {
        int digits = 0;

        String digitChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = digitChars.charAt(x % radix); // radix로 나눈 나머지를 저장
            x /= radix;
        } while (x != 0);
        // 배열 d에 저장된 값을 역순으로 재배치
        for (int i = 0; i < digits / 2; i++) {
            char temp = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = temp;
        }
        return digits;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number; // 변환할 10진수 정수
        int radix;  // 변환할 기수
        int digitNum; // 변환 후 자릿수
        int re;    // 반복 여부
        char[] result = new char[32]; // 변환 결과를 저장할 배열

        System.out.println("10진수를 다른 기수로 변환합니다.");
        do {
            do {
                System.out.print("변환할 정수(0 이상): ");
                number = sc.nextInt();
            } while (number < 0);

            do {
                System.out.print("변환할 기수(2~36): ");
                radix = sc.nextInt();
            } while (radix < 2 || radix > 36);

            digitNum = convertToRadix(number, radix, result);

            System.out.print(radix + "진수로는 ");
            for (int i = 0; i < digitNum; i++)
                System.out.print(result[i]);
            System.out.println(" 입니다.");

            System.out.print("한 번 더 할까요? (1.예 / 0.아니오): ");
            re = sc.nextInt();
        } while (re == 1);
    }
}