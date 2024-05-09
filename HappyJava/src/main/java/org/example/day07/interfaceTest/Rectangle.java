package org.example.day07.interfaceTest;

public class Rectangle extends Shape implements Drawable{

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

    @Override
    public void draw() {
        System.out.println("사각형을 그립니다.");
    }
}
