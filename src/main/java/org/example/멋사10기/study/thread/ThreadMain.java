package org.example.멋사10기.study.thread;

public class ThreadMain {
    public static void main(String[] args) {
        ThreadExam thread = new ThreadExam("*");
        ThreadExam thread2 = new ThreadExam("-");

        thread.start();
        thread2.start();

        System.out.println("main end!!");
    }
}
