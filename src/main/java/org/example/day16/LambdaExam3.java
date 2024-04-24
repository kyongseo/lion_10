package org.example.day16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaExam3 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("kss","msssss", "dsssss");

        // 기존
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println("names : " + names);

        // 람다식
        names.sort((String s1, String s2) -> s1.compareTo(s2));

        System.out.println("sorted : " + names);
    }
}

