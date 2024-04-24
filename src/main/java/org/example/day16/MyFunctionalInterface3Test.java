package org.example.day16;

public class MyFunctionalInterface3Test {
    public static void main(String[] args) {

        MyFunctionalInterface3 f3;

        f3 = (x, y) -> {
            int sum = x * y;
            System.out.println(x + " + " + y + " = " + sum);
        };

        f3.method1(2,5);
    }
}
