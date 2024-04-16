package org.example.day11;

import java.util.ArrayList;
import java.util.List;

public class ListExam {

    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();

        fruits.add("사과");
        fruits.add("banana");
        fruits.add("cherry");

        String firstFruit = fruits.get(0);
        System.out.println(firstFruit);

        System.out.println(fruits);

        fruits.set(1, "blueberry");
        System.out.println(fruits);

        fruits.remove("cherry");
        System.out.println(fruits);
    }
}
