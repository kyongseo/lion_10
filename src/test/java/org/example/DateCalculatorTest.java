package org.example;

import org.example.ch01.DateCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateCalculatorTest {

    private DateCalculator dateCalculator;

    // 테스트 클래스가 실행될 때마다 매번 실행되는 메서드
    // 각 테스트들을 실행 하기 전 매번 새로운 객체 생성 => 초기화 하는 과정
    @BeforeEach
    void setup(){
        dateCalculator = new DateCalculator();
    }

    @Test
    void calculateAge(){
        LocalDate birthDate = LocalDate.of(2001,9,30);
        LocalDate currentDate = LocalDate.of(2024,3,18);

        //int expectedAge = 24;
        int expectedAge = 23;
        int actualAge = dateCalculator.calculateAge(birthDate, currentDate);
        assertEquals(expectedAge, actualAge);

//        Assertions.assertEquals(2, dateCalculator.calculateAge(birthDate,currentDate));
    }

    @Test
    void testCalculateDayBetween(){
        LocalDate startDate = LocalDate.of(2024,3,1);
        LocalDate endDate = LocalDate.of(2024,3,31);
        int expectedDays= 14;
        int actualDays = dateCalculator.calculateBetween(startDate, endDate);
    }

    @Test
    void testIsLeapYear(){
        int leapYear = 2024;
        boolean isLeap = dateCalculator.isLeapYear(leapYear);
        assertEquals(true, isLeap);
    }
}
