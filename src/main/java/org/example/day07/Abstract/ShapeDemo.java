package org.example.day07.Abstract;

public class ShapeDemo {

    public static void main(String[] args) {
        Shape triangle = new Triangle(10,5);
        System.out.println("삼각형의 너비 : " + triangle.calculate());

        Shape rectangle = new Rectangle(10,5);
        System.out.println("사각형의 너비 : " + rectangle.calculate());
    }
}
