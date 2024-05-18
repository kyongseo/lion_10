package org.example.멋사10기.study.collection;

import java.util.*;

public class SetExam {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("h");
        set1.add("i");

        // 셋에서 자료를 하나씩 꺼내기 위해 Iterator 인터페이스 이용
        Iterator<String> it = set1.iterator();
        while (it.hasNext()) { // 데이터가 있는동안에 true
            System.out.println(it.next());
        }

    }
}