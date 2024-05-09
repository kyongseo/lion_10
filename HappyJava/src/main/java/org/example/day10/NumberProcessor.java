package org.example.day10;

import java.util.Arrays;
import java.util.List;

public class NumberProcessor {

    // 제너릭 메서드 정의 T는 넘버를 상속받고 sum 메서드 정의
    public static <T extends Number> double sum(List<T> numbers) {
        double total = 0.0;
        for (Number number : numbers) {
            total += number.doubleValue();
        }
        return total;
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3);
        List<Double> doubleList = Arrays.asList(1.5,2.7,4.7);

        System.out.println(sum(integerList));
        System.out.println(sum(doubleList));
    }
}
