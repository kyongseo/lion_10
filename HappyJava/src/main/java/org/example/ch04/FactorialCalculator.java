package org.example.ch04;

import java.util.Scanner;

public class FactorialCalculator {

    static int couple(int n){
        int sum = 0;
        if (n > 0) {
            sum = n * couple(n - 1);
            return sum;
        } else
            return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력해주세요.");
        int num = sc.nextInt();

        System.out.println(num + "의 팩토리얼 : " + couple(5));
    }
}
