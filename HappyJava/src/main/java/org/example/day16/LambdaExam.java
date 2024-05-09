package org.example.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaExam {

    public static void main(String[] args) {
        List<String> lists = Arrays.asList("a","b","c");

        lists.forEach(list -> System.out.println(list));

        // Thread 생성
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Start!");

            }
        }).start();

        /**
         * Lambda 사용
         */
        new Thread(() -> {
            System.out.println("Thread2 Start!");
        }).start();
    }
}
