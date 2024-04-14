package org.example.toyproject;

import java.util.Calendar;
import java.util.Scanner;

public class CalenderTest {

    public void makeCal(int year, int month){
        Calendar calendar = Calendar.getInstance();
        System.out.printf("\t\t%d년 %d월\t\n",year,month);
        System.out.printf("일\t월\t화\t수\t목\t금\t토\n");

        calendar.set(year, month -1 ,1);

        int start = calendar.get(calendar.DAY_OF_WEEK);

        for (int i = 1; i < start; i++){
            System.out.print("\t");
        }

        for (int i = 1; i < calendar.getActualMaximum(Calendar.DATE) +1 ; i++) {
            System.out.printf("%d\t", i);
            if (start % 7 == 0){
                System.out.println();
            }
            start++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        System.out.printf("년도를 입력하세요. : ");
//        int year = sc.nextInt();
//
//        System.out.printf("월을 입력하세요. : ");
//        int month = sc.nextInt();

        CalenderTest cal = new CalenderTest();
        cal.makeCal(2024,4);
    }
}
