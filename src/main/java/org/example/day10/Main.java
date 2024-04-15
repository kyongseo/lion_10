package org.example.day10;

public class Main {

    public static void main(String[] args) {
        Container<String> stringContainer = new StringContainer();
        stringContainer.set("Hello, Generic");

        System.out.println(stringContainer.get());

        Container<Integer> integerContainer = new IntegerContainer();
        integerContainer.set(20);

        System.out.println(integerContainer.get());
    }
}
