package org.example.day09;

import java.util.Scanner;

public class TimeExamMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("연도 입력: ");
        int year = sc.nextInt();

        System.out.print("월 입력: ");
        int month = sc.nextInt();

        TimeExam timeExam = new TimeExam();
        timeExam.makeCal(year, month);
    }
}
