package org.example.day13;

/**
 * Thread 사용방법
 * Thread 상속받고 run()메서드 오버라이딩 하기
 * 상속
 */
class MyThread extends Thread{
    @Override
    public void run() {

        System.out.println("MyThread Ready");

        //스레드가 실행할 작업
        for (int i =0; i <10; i++){
            System.out.println("MyThread hi");
        }
        System.out.println("MyThread exit");
    }
}

class KsThread extends Thread{
    @Override
    public void run() {

        System.out.println("ksThread Ready");

        //스레드가 실행할 작업
        for (int i =0; i <10; i++){
            System.out.println("ksThread hi");
        }
        System.out.println("ksThread exit");
    }
}
public class ThreadExam {
    public static void main(String[] args) {
        System.out.println("main Ready !!");

        // thread 생성
        MyThread myThread = new MyThread();
        myThread.start(); // 약속

        KsThread ksThread = new KsThread();
        ksThread.start();

        for (int i =0; i <10; i++){
            System.out.println("main hi");
        }
        System.out.println("main exit");
    }

}
