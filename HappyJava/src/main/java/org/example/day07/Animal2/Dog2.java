package org.example.day07.Animal2;

import org.example.day07.Animal2.Animal2;

public class Dog2 implements Animal2 {

    @Override
    public void move() {
        System.out.println("Dog 움직임");
    }

    @Override
    public void bark() {
        System.out.println("멍멍");
    }
}