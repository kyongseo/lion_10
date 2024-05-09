package org.example.day13;

public class RobotMain {
    public static void main(String[] args){

        Robot robot = new Robot();

        RobotPlayer playerA = new RobotPlayer("A", robot);
        RobotPlayer playerB = new RobotPlayer("B", robot);
        RobotPlayer playerC = new RobotPlayer("C", robot);

        playerA.start();
        playerB.start();
        playerC.start();


        Robot2 robot2 = new Robot2();
        RobotPlayer2 playerA2 = new RobotPlayer2("A", robot2);
        RobotPlayer2 playerB2 = new RobotPlayer2("B", robot2);
        RobotPlayer2 playerC2 = new RobotPlayer2("C", robot2);

        playerA2.start();
        playerB2.start();
        playerC2.start();

    }
}