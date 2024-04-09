package org.example.day07.interfaceTest;

public class Circle extends Shape implements Drawable{
    private double redius;

    public Circle(double redius) {
        this.redius = redius;
    }


    @Override
    public double calculate() {
        return redius * redius * Math.PI;
    }

    @Override
    public void draw(){
        System.out.println("원을 그립니다.");
    }

    @Override
    public void test() {
        System.out.println("Circle의 test입니다.");
    }
}
