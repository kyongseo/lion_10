package org.example.day07.interfaceTest;

public interface Drawable {
    default public void draw(){
        System.out.println("도형을 그립니다.");
    }

    // default 는 강제화가 안됨!
    default public void test(){
        System.out.println("테스트합니다.");
    }
}
