package org.example.멋사10기.study.thread;

/**
 * 동기화 메소드와 동기화 블록
 * 공유객체가 가진 메소드를 동시에 호출 되지 않도록 하는 방법
 * 메소드 앞에 synchronized 를 붙힌다.
 * 여러개의 Thread들이 공유객체의 메소드를 사용할 때 메소드에 synchronized가 붙어 있을 경우 먼저 호출한 메소드가 객체의 사용권(Monitoring Lock)을 얻는다.
 *
 * 메소드 앞에 synchronized 를 붙혀서 실행해 보면, 메소드 하나가 모두 실행된 후에 다음 메소드가 실행된다.
 * 해당 모니터링 락은 메소드 실행이 종료되거나, wait()와 같은 메소드를 만나기 전까지 유지된다.
 * 다른 쓰레드들은 모니터링 락을 놓을때까지 대기한다.
 * synchronized를 붙히지 않은 메소드는 다른 쓰레드들이 synchronized메소드를 실행하면서 모니터링 락을 획득했다 하더라도, 그것과 상관없이 실행된다.
 * synchronized를 메소드에 붙혀서 사용 할 경우, 메소드의 코드가 길어지면, 마지막에 대기하는 쓰레드가 너무 오래 기다리는것을 막기위해서 메소드에 synchronized를 붙이지 않고,
 * 문제가 있을것 같은 부분만 synchronized블록을 사용한다.
 */
public class MusicBox {

    public synchronized void playMusic1(){
        for (int i = 0; i < 10; i++){
            System.out.println("신나는 음악");

            try {
                Thread.sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void playMusic2(){
        for (int i = 0; i < 10; i++){
            System.out.println("신나는 음악222222222222222222");

            try {
                Thread.sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void playMusic3(){
        for (int i = 0; i < 10; i++){
            synchronized (this){
                System.out.println("신나는 음악33333333333333333333333333");
            }


            try {
                Thread.sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
