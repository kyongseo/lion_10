package org.example.day07.Abstract;

import org.example.day07.Abstract.Shape;

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculate() {
        return (base * height) / 2 ;
    }
}
