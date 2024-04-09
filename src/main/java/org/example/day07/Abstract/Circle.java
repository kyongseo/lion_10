package org.example.day07.Abstract;

import org.example.day07.Abstract.Shape;

public class Circle extends Shape {
    private double redius;

    public Circle(double redius) {
        this.redius = redius;
    }


    @Override
    public double calculate() {
        return redius * 3.14;
    }
}
