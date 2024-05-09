package org.example.day16;

import java.util.function.*;

// 표준 API가 제공하는 람다 인터페이스
public class LambdaExam4 {
    public static void main(String[] args) {
        /**
         * Predicate
         * 매개변수를 하나를 받아 불린 값을 반환
         */
        Predicate<Integer> predicate = x -> x > 0;
        System.out.println(predicate.test(2));
        System.out.println(predicate.test(-10));

        /**
         * Consumer
         * 하나의 매개변수 입력을 받고 반환 값이 없는 연산을 수행
         */
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("Hello ks");

        /**
         * Function
         * 하나의 입력을 받아서 서로 다른 형태의 결과 출력을 반환
         */
        Function<String , Integer> square = x -> x.length();
        System.out.println(square.apply("hello ks 22"));

        /**
         * Supplier
         * 입력 없이 값을 반환
         */
        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());

        /**
         * IntSupplier
         */
        IntSupplier intSupplier = () -> (int) (Math.random() * 100);
        System.out.println(intSupplier.getAsInt());

        /**
         * UnaryOperator
         */

        UnaryOperator<Integer> unaryOperator = x -> x * 2;
        System.out.println(unaryOperator.apply(2));

        /**
         * BiFunction
         * 두 개의 입력을 받고 하나의 결과를 반환
         */
        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x * y;
        System.out.println(biFunction.apply(1, 2));

        /**
         * Consumer 의 addThen 메소드 활용
         */
        Consumer<String> consumer1 = x -> System.out.println(x + " aaaa");
        Consumer<String> consumer2 = x -> System.out.println(x + " bbbb");

        consumer1.accept("ks");
        consumer2.accept("ks");

        Consumer<String> consumer12 = consumer1.andThen(consumer2);
        consumer12.accept("Hello ");
    }
}
