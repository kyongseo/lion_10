package org.example.day07.Animal2;

public interface Animal2 {
    public static final String name = "동물";

    public abstract void move();
    public abstract void bark();

    default String defaultMethod(){
        return "동물 소리";
    }
}