package org.example.ch04;

import java.util.Scanner;

public class Factorial2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 1;

        for (int i=1; i<=n;i++){
            sum *= i;
        }

        System.out.println(sum);

    }
}
