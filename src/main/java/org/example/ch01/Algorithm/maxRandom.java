package org.example.ch01.Algorithm;

import java.util.Random;
import java.util.Scanner;

/**
 * 난수 사용해 배열의 요솟값 설정하기
 */
public class maxRandom {

    static int maxOf(int[] weights){
        int max = weights[0];

        for (int i =1; i < weights.length; i++){
            if (weights[i] > max){
                max = weights[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.print("사람 수 >> ");
        int n = sc.nextInt();

        int[] weights = new int[n];

        for (int i =0; i < n ; i++){
            weights[i] = 40 + rd.nextInt(60); // 40~100
            System.out.println("weights[" + i +"] : " + weights[i]);
        }
        System.out.println(maxOf(weights));
    }
}
