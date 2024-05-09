package org.example;

import org.example.ch01.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator cal = new Calculator();

    @Test
    void plus(){
        System.out.println("plus test 실행");
        assertEquals(5,cal.plus(2,3));
        assertEquals(10, cal.plus(3,7));
    }
    @Test
    void minus(){
        System.out.println("minus test 실행");
        assertEquals(2,cal.minus(3,1));
    }

    //제일 먼저 실행됨 => 테스트를 실행하기 위한 기본 옵션같은 것들을 실행하기 위해..
    //static 메서드 필수
    @BeforeAll
    static void beforeAll(){
        System.out.println("====beforeAll==== 테스트 클래스가 실행될 때 한 번만 실행됨.");
    }

    // 테스트 클래스가 실행될 때마다 매번 실행되는 메서드
    @BeforeEach
    void beforeEach(){
        System.out.println("==beforeEach== 테스트 메서드가 실행되기 전에 실행. 모든 테스트 메서드마다 실행!!");
    }

    @AfterEach
    void afterEach(){
        System.out.println("==afterEach== 각 테스트 메소드가 실행 된 후 실행 !!");
    }

    // static 메서드 필수
    @AfterAll
    static void afterAll(){
        System.out.println("====afterAll==== 모든 메소드가 종료된 후 마지막 한번만 실행!!");
    }

}