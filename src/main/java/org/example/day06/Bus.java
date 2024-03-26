package org.example.day06;

public class Bus extends Car{
    public Bus() {
        super();
        System.out.println("Bus() 출력");
    }
     public Bus(String name){
        super(name);
        this.name = name;
         System.out.println("Bus(String name) 실행");
     }
}
