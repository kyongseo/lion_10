package org.example.day07.Abstract;

import org.example.day07.Abstract.Shape;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculate() {
        return (width * height);
    }
}
