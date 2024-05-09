package org.example.day09.InnerClass;

public class StaticClass {
    private static int outerFiled = 10;

    public void outerMethod(){
        InnerClass innerClass = new InnerClass();
        innerClass.innerMethod();
    }

    static class InnerClass {
        public void innerMethod(){
            System.out.println("outerFiled = " + outerFiled);
        }
    }

    public static void main(String[] args) {
        StaticClass staticClass = new StaticClass();
        staticClass.outerMethod();
    }
}
