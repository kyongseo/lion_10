package org.example.day07.interfaceTest;

public class Triangle extends Shape implements Drawable{
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

    @Override
    public void draw(){
        System.out.println("삼각형을 그립니다.");
    }
}

