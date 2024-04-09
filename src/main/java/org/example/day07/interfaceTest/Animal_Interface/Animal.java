package org.example.day07.interfaceTest.Animal_Interface;

public interface Animal {

    int AGE = 10; //static final 생략 => 대문자로 쓰는 것이 좋다!
    String Name = "no name";
    public default void speak(){

    }

    default void song(){
        System.out.println("노래를 부릅니다.");
    }
}
