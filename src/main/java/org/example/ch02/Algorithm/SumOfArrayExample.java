package org.example.ch02.Algorithm;

public class SumOfArrayExample {
    public static void main(String[] args) {
        int[] array = {5,10,15,20,25};

        System.out.println("합계를 구합니다.");
        for (int i = 0; i < array.length; i++)
            System.out.println("합계 " + array[i]);

        int sum = 0;
        for (int num:array)
            sum += num;
        System.out.println(sum);
    }
}
