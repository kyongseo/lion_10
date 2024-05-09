package org.example.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaExam5 {

    public static void main(String[] args) {
        /**
         * 메소드 참조
         * 클래스 :: 정적메소드
         */
        BiFunction<Integer, Integer, Integer> maxFunc = Math::max;
        System.out.println("max value: " + maxFunc.apply(1, 2));

        // 기존
        // BiFunction<Integer, Integer, Integer> maxFunc = (a,b) -> Math.max(a,b);

        /**
         * 인스턴스 메서드 참조
         * 객체참조변수 :: 인스턴스메서드
         */
         String str = "Hello World!";
         Supplier<Integer> lengthFunc = str::length;
        System.out.println("str의 글자 수 : " + lengthFunc.get());

        System.out.println();

        /**
         * 임의 객체의 인스턴스 메소드 참조
         * 클래스 :: 인스턴스메소드
         */
        // 람다식 사용
        System.out.println("람다식 사용");
        List<String> words = Arrays.asList("Hello", "World", "Java");
        words.forEach(word -> System.out.println(word));

        System.out.println();

        // 메소드 참조
        System.out.println("메소드 참조");
        words.forEach(System.out::println);

        System.out.println();

        /**
         * 생성자 참조
         * 생성자 :: new
         */
        System.out.println("생성자 참조");
        Supplier<List<String>> wordsSupplier = ArrayList::new;

        List<String> list = wordsSupplier.get();
        list.add("hello");
        list.add("world");
        list.add("java");

        list.forEach(System.out::println);
        System.out.println(list);
    }
}
