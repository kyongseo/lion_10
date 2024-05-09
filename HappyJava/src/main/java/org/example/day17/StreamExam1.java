package org.example.day17;

import javax.swing.*;
import java.time.format.SignStyle;
import java.util.*;
import java.util.stream.Collectors;

public class StreamExam1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d");

        List<String> myList = list.stream()
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());
        System.out.println(myList);

        // 스트림 사용하지 않고 만들기
        List<String> filterList1 = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("a")) {
                filterList1.add(s);
            }
            System.out.println(filterList1);

            String[] names = {"a", "b", "c", "d"};

            for (String name : names) {
                System.out.println(name);
            }

            Arrays.stream(names).forEach(System.out::println);
        }

        // 짝수만 출력
        int[] iarr = {1, 2, 3, 4, 5, 6};

        for (Integer i : iarr) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        Arrays.stream(iarr).filter(i -> i % 2 == 0).forEach(System.out::println);

        /**
         * filter 메소드
         * 글자수가 5 이상인 것만 필터링하고, 중복은 제거해서 새로운 리스트로 얻어온다.
         */

        List<String> words = Arrays.asList("apple", "banana", "cherry", "data", "apple");

        // 스트림 사용 XX
        List<String> uniqueWords = new ArrayList<>();
        for (String w : words) {
            if (w.length() >= 5) {
                uniqueWords.add(w);
            }
        }
        System.out.println(uniqueWords);

        // 스트림 사용
        List<String> uniqueWords2 = words.stream()
                .filter(w -> w.length() >= 5)
                .collect(Collectors.toList());

        System.out.println(uniqueWords2);

        /**
         * map 메소드
         * 스트림의 각 요소를 주어진 함수에 따라 다른 형태로 변환
         * 각 요소에 3씩 곱하기
         */

        int[] intArr = {1, 2, 3, 4, 5};

        Arrays.stream(intArr)
                .map(x -> x * 3)
                .forEach(System.out::println);

        /**
         * flatMap 메소드
         * 중첩된 구조를 평탄화하는 데 사용
         */

        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Apple", "Banana"),
                Arrays.asList("Cherry", "Data")
        );

        List<String> flattendList = nestedList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(flattendList);

        List<String> list2 = Arrays.asList("hello java", "hi ks", "lambda Stream");
        list2.stream().flatMap(s -> Arrays.stream(s.split(" "))).forEach(System.out::println);

        List<String> list3 = Arrays.asList("1  , 3  ,6    7,4,    5");
        list3.stream()
                .flatMapToInt(
                        data -> {
                            String[] strArr = data.split(",");
                            int[] omtArr = new int[strArr.length];
                            for (int i = 0; i < strArr.length; i++ ) {
                                intArr[i] = Integer.parseInt(strArr[i].trim());
                            }
                            return Arrays.stream(intArr);
                        })
                .forEach(System.out::println);
        System.out.println("\n==================================");
        list3.stream().flatMapToInt(data -> Arrays.stream(data.split(","))
                .mapToInt(str -> Integer.parseInt(str.trim())))
                .forEach(System.out::println);

        int[] iarr3 = {5, 23, 12, 412, 5234, 312, 12, 9};

        // 오름차순으로 정렬 후 출력
        Arrays.stream(iarr)
                .sorted()
                .forEach(n -> System.out.print(n + " "));

        System.out.println();

        // 내림차순으로 정렬 후 출력
        Arrays.stream(iarr3)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(n -> System.out.print(n + " "));
    }
}


