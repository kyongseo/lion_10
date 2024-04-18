package org.example.day13.동시카운터;

public class CounterApp  {
    public static void main(String[] args) {

        Thread increment = new Thread(new IncrementCounter());
        Thread decrement = new Thread(new DecrementCounter());

        increment.start();
        decrement.start();
    }

    static class IncrementCounter implements Runnable{
        @Override
        public void run() {
            for (int i = 1; i<=100; i++){
                System.out.println("Increment : {" + i + "}");

                try {
                    Thread.sleep((int) (Math.random() * 10));
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
            System.out.println("IncrementCounter 종료");
        }
    }

    static class DecrementCounter implements Runnable{
        @Override
        public void run() {
            for (int i =100 ;i>=1; i--){
                System.out.println("Decrement : {" + i +"}");

                try {
                    Thread.sleep((int) (Math.random() * 10));
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
            System.out.println("DecrementCounter 종료");
        }
    }
}
