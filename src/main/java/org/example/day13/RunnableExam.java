package org.example.day13;

/**
 * 인터페이스를 상속받아 구현
 */
class MyRunnable implements Runnable{ // MyRunnableThread은 Thread가 아니다.
    @Override
    public void run() {
        System.out.println("MyRunnable Ready");

        //스레드가 실행할 작업
        for (int i =0; i < 10; i++){
            System.out.println("MyRunnable hi");
        }
        System.out.println("MyRunnable exit");
    }
}
class KsRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("ksRunnable Ready");

        for (int i = 0; i< 10; i++) {
            System.out.println("ksRunnable hi");
        }
        System.out.println("ksRunnable exit");
    }
}

public class RunnableExam{

    public static void main(String[] args) {
        System.out.println("main Ready");

        // Runnable 인터페이스는 명시적으로 Thread 객체를 생성해야 한다.
        Thread myThread = new Thread(new MyRunnable());
        myThread.start();

        Thread ksThread = new Thread(new KsRunnable());
        ksThread.start();

        //스레드가 실행할 작업
        for (int i =0; i < 10; i++){
            System.out.println("main hi");
        }
        System.out.println("main exit");
    }
}
