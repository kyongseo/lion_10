package org.example.멋사10기.study.thread;

/**
 * 쓰레드와 상태제어(wait, notify)
 * wait와 notify는 동기화된 블록안에서 사용해야 한다.
 * wait를 만나게 되면 해당 쓰레드는 해당 객체의 모니터링 락에 대한 권한을 가지고 있다면 모니터링 락의 권한을 놓고 대기한다.
 */
public class ThreadExam4 extends Thread{
    int total;

    @Override
    public void run() {
        synchronized (this) { // 동기화
            for (int i = 0; i < 5; i++) {
                System.out.println(i +"를 더합니다.");
                total += i;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            notify();
        }
    }
}
