package org.example.day16;

import java.util.*;
import java.util.function.Consumer;

public class LambdaExam2 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println("numbers: " + numbers);
        Collections.sort(numbers, (Integer o1, Integer o2) -> o1.compareTo(o2));

        numbers.forEach(number -> System.out.print(number));
    }
}
