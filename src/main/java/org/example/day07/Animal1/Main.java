package org.example.day07.Animal1;

import org.example.day07.Animal1.Cat;
import org.example.day07.Animal1.Dog;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("강아지",3);
        Cat cat = new Cat("고양이",3);

        dog.move();
        dog.bark();
        cat.move();
        cat.bark();
    }
}