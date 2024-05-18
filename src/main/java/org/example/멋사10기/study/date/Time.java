package org.example.멋사10기.study.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class Time {

    public static void main(String[] args) {
        // Date
        System.out.println("================================Date================================");

        Date date = new Date();
        System.out.println(date);

        System.out.println(date.toString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a zzz");
        System.out.println(sdf.format(date));

        System.out.println(date.getTime()); // 현재 시간 (1)

        long today = System.currentTimeMillis(); // 현재 시간 (2)
        System.out.println(today);

        // Calender
        System.out.println("================================Calender================================");

        Calendar cal = Calendar.getInstance();

        cal.setTime(date);
        System.out.println("Calendar.YEAR : " + cal.get(Calendar.YEAR));
        System.out.println("Calendar.MONTH : " + cal.get(Calendar.MONTH) +1);
        System.out.println("Calendar.DATE : " + cal.get(Calendar.DATE));
        System.out.println("Calendar.DAY_OF_MONTH : " + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("Calendar.HOUR_OF_DAY : " + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("Calendar.MINUTE : " + cal.get(Calendar.MINUTE));
        System.out.println("Calendar.SECOND : " + cal.get(Calendar.SECOND));
        System.out.println("Calendar.MILLISECOND : " + cal.get(Calendar.MILLISECOND));
        System.out.println("getTime : " + cal.getTime());
        System.out.println("getTimeInMillis : " + cal.getTimeInMillis());
        System.out.println("getTimeZone : " + cal.getTimeZone());
        System.out.println("cal.getTimeZone().getID : " + cal.getTimeZone().getID());

        cal.add(Calendar.DATE, -1);
        System.out.println("Calendar.DATE add -1 : " + cal.get(Calendar.DATE));


        // time
        System.out.println("================================Time 패키지================================");

        LocalDateTime timePoint = LocalDateTime.now();
        System.out.println("LocalDateTime : " + timePoint);
        LocalDate theDate = timePoint.toLocalDate();
        System.out.println("LocalDate : " + theDate);
        System.out.println("getMonthValue : " + timePoint.getMonthValue());
        System.out.println("getMonth : " + timePoint.getMonth());

        LocalDate lod = LocalDate.of(2018, Month.MAY, 1);
        System.out.println("LocalDate : " + lod);

        LocalTime lot = LocalTime.of(17, 59, 59);
        System.out.println("LocalTime : " + lot);

    }
}
//public class CalendarExam{
//    public String hundredDaysAfter(){
//        //오늘부터 100일 뒤의 날짜를 "2016년1월1일"의 형식으로 return하세요.
//        Calendar cal=Calendar.getInstance();
//        cal.add(Calendar.DATE,100);
//        int year=cal.get(Calendar.YEAR);
//        int month=cal.get(Calendar.MONTH)+1;
//        int date=cal.get(Calendar.DATE);
//        String cals = year+"년"+month+"월"+date+"일";
//        return cals;
//    }
//    public static void main(String[] args){
//        CalendarExam ce=new CalendarExam();
//        System.out.println(ce.hundredDaysAfter());
//    }
//}

