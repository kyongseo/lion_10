package org.example.day17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExam2 {
    public static void main(String[] args) throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // forEach
        numbers.stream()
                .forEach(n -> System.out.println("numbers : " + n));

        // peak
        List<Integer> doubleNumbers = numbers.stream()
                .peek(n -> System.out.println("Processing 1 : " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("Processing 2 : " + n))
                .collect(Collectors.toList());
    }
}
