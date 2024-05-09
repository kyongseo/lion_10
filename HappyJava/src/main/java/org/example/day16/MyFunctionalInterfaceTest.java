package org.example.day16;

class MyFunctionalInterfaceImpl implements MyFunctionalInterface1 {
    @Override
    public void method1() {
        System.out.println("MyFunctionalInterface Method 1 call");
    }
}

public class MyFunctionalInterfaceTest {

    public static void main(String[] args) {

        MyFunctionalInterface1 myFunctionalInterface;
        MyFunctionalInterface1 myFunctionalInterface1;
        MyFunctionalInterface1 myFunctionalInterface2;

        myFunctionalInterface = new MyFunctionalInterfaceImpl();
        MyFunctionalInterface1 myFunctional = new MyFunctionalInterface1() {

            @Override
            public void method1() {
                System.out.println("method 1 call");
            }

//            @Override
//            public void method2() {
//                System.out.println("method 2 call");
//            }
//
//            @Override
//            public void method3() {
//                System.out.println("method 3 call");
//            }
        };
        /**
         * 인터페이스를 람다로 사용할 경우 인터페이스 안에 메소드가 1개 여야지 람다 함수 사용 가능
         */

        myFunctional.method1();
        myFunctionalInterface.method1();

        myFunctionalInterface = () -> System.out.println("method 1");

        myFunctionalInterface1 = new MyFunctionalInterfaceImpl();
        myFunctionalInterface1.method1();

    }
}
