package org.example.멋사10기.study.thread;

/**
 * 쓰레드와 상태제어(join)
 * 쓰레드가 3개가 있다면 JVM은 시간을 잘게 쪼갠 후에 한번은 쓰레드1을, 한번은 쓰레드 2를, 한번은 쓰레드 3을 실행합니다. 이것에 빠르게 일어나다 보니 쓰레드가 모두 동작하는 것처럼 보이는 것이다.
 * 쓰레드는 실행가능상태인 Runnable과 실행상태인 Running상태로 나뉜다.
 * 실행되는 쓰레드 안에서 Thread.sleep()이나 Object가 가지고 있는 wait()메소드가 호출이 되면 쓰레드는 블록상태가 된다.
 * Thread.sleep()은 특정시간이 지나면 자신 스스로 블록상태에서 빠져나와 Runnable이나 Running상태가 된다.
 * Object가 가지고 있는 wait()메소드는 다른 쓰레드가 notify()나 notifyAll()메소드를 호출하기 전에는 블록상태에서 해제되지 않는다.
 * wait()메소드는 호출이 되면 모니터링 락을 놓게 된다. 그래서 대기중인 다른 메소드가 실행한다.
 * 쓰레드의 run메소드가 종료되면, 쓰레드는 종료된다. 즉 Dead상태가 된다.
 * Thread의 yeild메소드가 호출되면 해당 쓰레드는 다른 쓰레드에게 자원을 양보하게 된다.
 * Thread가 가지고 있는 join메소드를 호출하게 되면 해당 쓰레드가 종료될 때까지 대기하게 된다.
 *
 * join()메소드는 쓰레드가 멈출때까지 기다리게 한다.
 */
public class ThreadExam3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread3 : " + i);

            try {
                Thread.sleep(500); //일단 0.5초씩 쉬면서 숫자를 출력하는 MyThread5를 작성해 보도록 하겠습니다.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
