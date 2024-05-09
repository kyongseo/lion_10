package org.example.ch04;

import java.util.Scanner;
//최대공약수 = 나머지 중 가장 작은 값
class GCDCalculator  {
    //--- 숫자 n을 사용하여 순수 재귀 패턴을 생성하고 출력하는 메서드 ---//
    static void displayPattern(int n) {
        if (n > 0) {
            displayPattern(n - 1); // 첫 번째 재귀 호출

            System.out.println("Number: " + n);

            displayPattern(n - 2); // 두 번째 재귀 호출
        }
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("출력할 숫자를 입력하세요: "); //5
        int x = stdIn.nextInt();
        displayPattern(x); //5
    }
}