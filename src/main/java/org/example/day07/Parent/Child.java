package org.example.day07.Parent;

import java.security.PublicKey;

public class Child extends Parent{

    public Child(){
        super("no name", 10);
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public String getName(){
        System.out.println("나는 자식클래스에서 구현한 getName()입니다.");
        return super.getName;
    }
}
