package org.example.day09;
import java.util.Calendar;
import java.util.Scanner;

public class TimeExam {

    //달력 만들기
    public void makeCal(int year, int month) {
        Calendar calendar = Calendar.getInstance();

        System.out.printf("\t\t%d년 %d월\n", year, month);
        System.out.printf("일\t월\t화\t수\t목\t금\t토\n");

        calendar.set(year, month - 1, 1);

        int start = calendar.get(Calendar.DAY_OF_WEEK);

        for (int i = 1; i < start; i++) {
            System.out.print("\t");
        }

        for (int i = 1; i < calendar.getActualMaximum(Calendar.DATE) + 1; i++) {
            System.out.printf("%d\t", i);
            if (start % 7 == 0) {
                System.out.println();
            }
            start++;
        }
    }
}



