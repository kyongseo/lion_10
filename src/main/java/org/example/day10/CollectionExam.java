package org.example.day10;

import java.util.ArrayList;

public class CollectionExam {

    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();

        strList.add("a");
        strList.add("b");
        strList.add("c");

        for (String str : strList) {
            System.out.println(str);
        }

        System.out.println("===========");
        System.out.println(strList.get(3));

        System.out.println(strList.getLast());
    }
}
