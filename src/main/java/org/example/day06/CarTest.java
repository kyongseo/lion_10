package org.example.day06;

import javax.xml.namespace.QName;

public class CarTest {

    public static void main(String[] args) {
        Car car = new Car("BMW");
        System.out.println(car.name);

        System.out.println("--------------");

        Bus bus = new Bus("붕붕");
        System.out.println(bus.name);
    }
}
