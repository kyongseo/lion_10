package org.example.day16;

public class MyFunctionalInterface2Test {
    public static void main(String[] args) {

        MyFunctionalInterface2 f2;

        // 기존
        f2 = new MyFunctionalInterface2() {
            @Override
            public void method(int x) {
                int sum = x * 2 ;
                System.out.println(sum);
            }
        };

        // 람다 사용
        f2 = x -> {
            int sum = x * 2;
            System.out.println(sum);
        };

        f2 = (int x) -> {
            int sum = x * 2;
            System.out.println(sum);
        };

        f2 = (x) -> {
            int sum = x * 2;
            System.out.println(sum);
        };

        f2.method(5);
    }
}
