package org.example.day08.Exception;

/**
 * 예외종류 2가지
 * 1. 실행시 발생하는 예외(Runtime)
 *  2. 컴파일 시 발생하는 예외(Checked)
 */


/**
 * 예외 처리방법 2가지
 * 1. try-catch
 * 2. throws
 */

public class ExceptionExam3 {

    public static void 심부름(){
        System.out.println("심부름 시작");

        int i =0;
        try {
            System.out.println(10/i);
        }catch (Exception e) {
            System.out.println("다른 마트 감");
        }

        System.out.println("심부름 끝");
    }
    public static void main(String[] args) {

        심부름();
    }
}
