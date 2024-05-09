package org.example.day06;

public class Car {
    String name;
    int speed;
    public Car(){
        System.out.println("Car() 생성자 호출됨.");
    }

    public Car(String name) {
        this.name = name;
        System.out.println("Car(String name) 생성자 호출됨.");
    }

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
        System.out.println("Car(String name, int speed) 생성자 호출됨.");
    }

}
