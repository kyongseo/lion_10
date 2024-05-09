package org.example.ch01.Algorithm;

/**
 * 세 값의 최댓값 구하기
 */
public class MaxValue {
    public static int max(int a, int b, int c){
        int max = a;

        if (b > max) {
            max = b;
        } if (c>max){
            max =c;
        } return max;
    }
    public static void main(String[] args) {
//        int a = 34;
//        int b = 20;
//        int c = 76;
//        int result = max(a, b, c);
//        System.out.println(result);

        MaxValue maxValue = new MaxValue();
        maxValue.max(1,7,6);

        System.out.println(MaxValue.max(7,76,5));
    }
}
