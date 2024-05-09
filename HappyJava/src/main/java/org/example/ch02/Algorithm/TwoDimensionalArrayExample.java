package org.example.ch02.Algorithm;

public class TwoDimensionalArrayExample {
    public static void main(String[] args) {
        int[][] score = {{90,80,70,60},{80,70,60,50},{70,60,50,40}};
        int sum = 0;
        for (int i = 0; i <score.length;i++){
            System.out.println((i+1) + " 학생의 점수");
            for (int j = 0; j <score[i].length;j++){
                System.out.println(score[i][j]);
                sum += score[i][j];
            }System.out.println();
        }
        System.out.println("합계는 : " + sum);
        System.out.println("평균은 : " + sum/score.length);
    }
}
