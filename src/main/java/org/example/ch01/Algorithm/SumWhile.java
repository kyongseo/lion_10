package org.example.ch01.Algorithm;

import java.util.Scanner;

public class SumWhile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int i = 1;

        int num = sc.nextInt();

        while (i <= num) {
            sum += i;
            i++;
        }
        
        System.out.println(sum);
    }
}
