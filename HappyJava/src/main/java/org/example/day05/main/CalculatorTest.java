package org.example.day05.main;

import org.example.day05.util.Calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.plus(1,4));
        System.out.println(cal.minus(1,4));
    }
}
