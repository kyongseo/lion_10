package org.example.day08.Exception;

public class ExceptionExam2 {
    public static void main(String[] args) {
        System.out.println("프로그램 시작");

        int i = Integer.parseInt(args[0]);

        try{
            System.out.println(10/i);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("프로그램 종료");

    }
}
