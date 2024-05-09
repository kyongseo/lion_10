package org.example.day07.interfaceTest.Vehicle_Interface;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car();
        car.accelerate(100);
        car.accelerate(300);
        car.accelerate(50);
        car.decelerate(30);
        car.decelerate(50);
    }
}
