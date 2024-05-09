package org.example.day16;

public class IntBinaryOperationTest {

    public static void main(String[] args) {
        IntBinaryOperation test;

        test = new IntBinaryOperation() {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        };

        IntBinaryOperation test2 = (a,b) -> 0;
        IntBinaryOperation add = (a,b) -> a + b;
        IntBinaryOperation minus = (a,b) -> a - b;
        IntBinaryOperation division = (a,b) -> a / b;

    //    System.out.println(test2.apply(1,1));
        System.out.println(test.apply(1,2));
        System.out.println(add.apply(1,4));
        System.out.println(minus.apply(10,1));
        System.out.println(division.apply(8,2));
    }
}
