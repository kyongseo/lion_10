package org.example.day16;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructTest {
    public static void main(String[] args) {

        Function<String, Car> function2 = name -> new Car(name);
        Car car2 = function2.apply("run");
        System.out.println(car2.toString());

        Function<String, Car> function = Car::new;
        Car car = function.apply("BMW");
        System.out.println(car.toString());

        BiFunction<String, String, Car> biFunction = Car::new;
        Car car3 = biFunction.apply("Audi", "100");
        System.out.println(car3.toString());
    }
}
class Car {
    String name;
    String speed;

    public Car(String name, Object speed) {
    }
    public Car(String name) {
        this.name = name;
    }
    public Car(String name, String spped) {
        this.name = name;
        this.speed = spped;
    }

    @Override
    public String toString() {
        return name + ", " + speed;
    }
}