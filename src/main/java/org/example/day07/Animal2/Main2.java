package org.example.day07.Animal2;

import org.example.day07.Animal2.Cat2;
import org.example.day07.Animal2.Dog2;

public class Main2 {
    public static void main(String[] args) {
        Dog2 dog = new Dog2();
        Cat2 cat = new Cat2();

        dog.move();
        dog.bark();
        System.out.println(dog.defaultMethod());

        cat.move();
        cat.bark();
        System.out.println(cat.defaultMethod());
    }
}