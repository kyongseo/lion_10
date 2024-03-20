package org.example.ch01.Algorithm;

import javax.imageio.stream.ImageInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class InvertArr {

    static void swap(int[] a, int idx1, int idx2){
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void reverse(int[] a) {
        for (int i =0; i <a.length /2 ; i++){
            swap(a,i,a.length-i-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("개수 : ");
        int num = sc.nextInt();

        int[] scores = new int[num];

        for (int i = 0 ; i < num; i++){
            System.out.println("scores[" + i + "] :");
            scores[i] = sc.nextInt();
        }

        reverse(scores);

        System.out.println("scores = " + Arrays.toString(scores));
    }
}
