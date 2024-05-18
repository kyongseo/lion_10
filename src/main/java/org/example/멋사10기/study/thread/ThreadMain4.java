package org.example.멋사10기.study.thread;

public class ThreadMain4 {
    public static void main(String[] args) {
        ThreadExam4 t1 = new ThreadExam4();
        t1.start();

        // b에 대하여 동기화 블럭을 설정
        // 만약 main쓰레드가 아래의 블록을 위의 Thread보다 먼저 실행되었다면 wait를 하게 되면서 모니터링 락을 놓고 대기
        synchronized (t1) {
            try {
                //wait()메소드를 호출.
                //메인쓰레드는 정지
                //ThreadB가 5번 값을 더한 후 다른 스레드가 notify를 호출하게 되면 wait에서 깨어남
                System.out.println("t1 완료될때까지 기다립니다.");
                t1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //깨어난 후 결과를 출력
            System.out.println("total = " + t1.total);
        }
    }
}
