package org.example.day11;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetExam {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("a");
        set.add("b");
        set.add("c");

        System.out.println(set);

        if (set.contains("a")){
            System.out.println("a 있음");
        }

        set.add("a");

        System.out.println(set);

        System.out.println(set.size());
    }

}
