package org.example.day09;

import java.util.Calendar;

public class CalendarExam {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        //특정 날짜로 설정
        calendar.set(2024, Calendar.JANUARY, 1);
        System.out.println(calendar.toString());

        calendar.add(Calendar.YEAR,1);
        calendar.add(Calendar.MONTH,-3);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println(year +"년 " + month + "월 " + day + "일");

    }
}
