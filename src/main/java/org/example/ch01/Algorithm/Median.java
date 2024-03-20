package org.example.ch01.Algorithm;

import java.util.Scanner;

public class Median {

    static int med(int a, int b, int c){
        if (a >= b)
            if (b >=c)
                return b;
            else if (a <= c)
                return a;
            else
                return c;
        else if (a > c)
                return a;
        else if (b > c)
            return c;
        else return b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("중앙값 구하기");
        System.out.println("a : ");
        int a = sc.nextInt();
        System.out.println("b : ");
        int b = sc.nextInt();
        System.out.println("c : ");
        int c = sc.nextInt();

        System.out.println("중앙값은 " + med(a,b,c) + "입니다.");
    }
}
