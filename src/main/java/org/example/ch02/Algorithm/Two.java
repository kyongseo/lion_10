package org.example.ch02.Algorithm;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("학생 수를 입력해주세요 : ");
        int n = sc.nextInt();

        System.out.print("과목 수를 입력해주세요 : ");
        int m = sc.nextInt();

        int[][] scores = new int[n][m];

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                System.out.print(i+1 + "번째 학생의 " + (j+1) + "번째 과목 점수를 입력해주세요 : ");
                scores[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println((i+1) + "번째 학생의 점수는");
            for (int j = 0; j < m; j++) {
                System.out.print(" " + scores[i][j]);
            }System.out.println();
        }
        sc.close();
    }
}
