package org.example.day07.interfaceTest.Vehicle_Interface;

public interface Calculator {
    static int add(int a, int b){
        return a+b;
    }
    static int minus(int a, int b){
        return a-b;
    }

    static void light() {
        System.out.println("불을 밝히다.");
    }
}
