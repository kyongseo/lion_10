package org.example.day16;

class MyFunctionalInterfaceImpl implements MyFunctionalInterface {
    @Override
    public void method1() {
        System.out.println("MyFunctionalInterface Method 1 call");
    }
}

public class MyFunctionalInterfaceTest {

    public static void main(String[] args) {

        MyFunctionalInterface myFunctionalInterface;
        MyFunctionalInterface myFunctionalInterface1;
        MyFunctionalInterface myFunctionalInterface2;

        myFunctionalInterface = new MyFunctionalInterfaceImpl();
        MyFunctionalInterface myFunctional = new MyFunctionalInterface() {

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
