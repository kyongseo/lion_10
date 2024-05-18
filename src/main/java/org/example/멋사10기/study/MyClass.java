package org.example.멋사10기.study;

public class MyClass {
    public void method1(){
        System.out.println("MyClass.method1");
    }

    public void method2(int x){
        System.out.println("MyClass.method2 : " + x);
    }

    public int method3(){
        System.out.println("MyClass.method3");
        return 10;
    }

    public void method4(int x, int y){
        System.out.println("MyClass.method4 : " + x + y);
    }

    public int method5(int x, int y){
        System.out.println("MyClass.method5");
        return x+y;
    }
}
