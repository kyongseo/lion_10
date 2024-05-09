package org.example.ch01.Algorithm;

import java.util.Scanner;

/**
 * 이등변삼각형
 */
public class Triangle2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("이등변삼각형의 단 수를 구합니다. >> ");

        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            for (int j = 0 ; j < n - i; j++) System.out.print(" ");

            for (int j = 0 ; j < (2*i+1) ; j++) System.out.print("*");
            System.out.println();
        }
    }
}
