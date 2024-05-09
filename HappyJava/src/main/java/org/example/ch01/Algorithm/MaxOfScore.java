package org.example.ch01.Algorithm;

import java.util.Scanner;

// 배열 요소의 최댓값을 출력하는 예제(사용자로부터 점수 입력받음)

public class MaxOfScore {
    static int maxOf(int[] scores){
        int max = scores[0];
        for (int i = 0; i < scores.length; i++){
            if (scores[i] > max)
                max = scores[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("학생 수 입력 : ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        for (int i = 0; i < n; i++){
            System.out.print("학생" + i + "의 점수 : ");
            scores[i] = sc.nextInt();
        }
        System.out.println(maxOf(scores));
    }
}
//package com.example.chap02;
//
//        import java.util.Scanner;
//
//public class FindMaxScore {
//    public static void main(String[] args) {
//        int[] scores = input();
//        System.out.println("max score : " + max(scores));
//    }
//
//    public static int[] input() {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("input student num : ");
//        int studentNum = sc.nextInt();
//
//        int[] scores = new int[studentNum];
//
//        for (int i = 1; i <= studentNum; i++) {
//            System.out.print("input student" + i + " score : ");
//            scores[i - 1] = sc.nextInt();
//        }
//
//        return scores;
//    }
//
//    private static int max(int[] scores) {
//        int max = 0;
//
//        for (int score : scores) {
//            if (score > max) {
//                max = score;
//            }
//        }
//        return max;
//    }
//}