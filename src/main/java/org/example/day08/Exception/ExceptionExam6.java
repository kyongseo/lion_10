package org.example.day08.Exception;

import java.util.Scanner;

/**
 * 사용자 정의  예외처리
 */
public class ExceptionExam6{
    public void inputScore(int score){
        if (score <1 || score >5) {
            throw new MyException("1-5점까지만 입력 가능합니다. 당신이 입력한 점수는 : " + score);
        }

        System.out.println(score);
    }

    public static void main(String[] args) {
        ExceptionExam6 exceptionExam6 = new ExceptionExam6();

        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 입력하세요. ");
        try {
            exceptionExam6.inputScore(sc.nextInt());

        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        System.out.println("main 종료");
    }


}
