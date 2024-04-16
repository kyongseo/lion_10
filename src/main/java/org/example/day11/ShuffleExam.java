package org.example.day11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ShuffleExam {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println("원래 : " + numbers);

        Collections.shuffle(numbers);
        System.out.println("섞기 " + numbers);
    }
}
