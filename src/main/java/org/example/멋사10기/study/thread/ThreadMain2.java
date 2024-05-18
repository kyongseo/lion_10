package org.example.멋사10기.study.thread;

public class ThreadMain2 {

    public static void main(String[] args) {
        ThreadExam2 thread1 = new ThreadExam2("*");
        ThreadExam2 thread2 = new ThreadExam2("-");

        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);

        t1.start();
        t2.start();

        System.out.println("main end");

    }
}
