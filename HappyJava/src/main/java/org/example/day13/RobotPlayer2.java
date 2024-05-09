package org.example.day13;

public class RobotPlayer2 extends Thread{
    private String name;
    private Robot2 robot2;

    public RobotPlayer2(String name,Robot2 robot2) {
        this.name = name;
        this.robot2 = robot2;
    }

    public void run(){
        if(name.equals("A")) {
            robot2.methodA();
        }else if(name.equals("B")) {
            robot2.methodB();
        }else{
            robot2.methodC();
        }
    }
}
