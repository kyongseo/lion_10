package org.example.day13;

/**
 *  멀티스레드
 *  synchronized 키워드 필수
 */
public class Robot {
    public synchronized void methodA(){
        for(int i = 1; i <= 5; i++){
            System.out.println("method A : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void methodB(){
        for(int i = 1; i <= 5; i++){
            System.out.println("method B : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public synchronized void methodC(){
        for(int i = 1; i <= 5; i++){
            System.out.println("method C : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}