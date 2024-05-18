package org.example.멋사10기.study.thread;

/**
 * 쓰레드 만들기(implements Runnable)
 * 자바에서 Thread를 만드는 방법은 크게 Thread 클래스를 상속받는 방법과 Runnable인터페이스를 구현하는 방법이 있다.
 * Runnable인터페이스를 구현해서 쓰레드를 만드는 방법
 * Runable 인터페이스가 가지고 있는 run()메소드를 구현한다.
 *
 * Runable 인터페이스를 구현한 MyThread2 사용하는 방법
 * MyThread2는 Thread를 상속받지 않았기 때문에 Thread가 아니다.
 * Thread를 생성하고, 해당 생성자에 MyThread2를 넣어서 Thread를 생성한다.
 * Thread 클래스가 가진 start()메소드를 호출한다.
 */
public class ThreadExam2 implements Runnable{
    String str;

    public ThreadExam2(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(str);

            try {
                Thread.sleep((int) Math.random() *1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
