package org.example.멋사10기.study.thread;

public class ThreadJoinMain3 {
    public static void main(String[] args) {
     ThreadExam3 t1 = new ThreadExam3();
     t1.start();

        System.out.println("Thread 시작");

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread 종료");
    }
}
