package org.example.ch01;

import java.time.LocalDate;
import java.time.Year;

public class DateCalculator {

    public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        return currentDate.getYear() - birthDate.getYear();
    }

    public int calculateBetween(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate).getDays();
    }

    public boolean isLeapYear(int year) {
        return LocalDate.ofYearDay(year,1).isLeapYear();
    }
}
