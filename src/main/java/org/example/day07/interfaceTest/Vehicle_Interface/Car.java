package org.example.day07.interfaceTest.Vehicle_Interface;

public class Car implements Vehicle{

    private int speed;

    @Override
    public void accelerate(int speed) {
        this.speed += speed;
        if (this.speed > MAX_SPEED) {
            this.speed = MAX_SPEED;
        }
        System.out.println("현재 속도 : " + speed + "km/h");
    }

    @Override
    public void decelerate(int speed) {
        this.speed -= speed;
        if (this.speed < 0) {
            this.speed = 0;
        }
        System.out.println("현재 속도 : " + speed + "km/h");
    }
}
