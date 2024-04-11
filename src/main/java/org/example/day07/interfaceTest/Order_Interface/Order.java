package org.example.day07.interfaceTest.Order_Interface;

public abstract class Order {
    public abstract void prepareFood();
    public abstract void serveFood();

    public final void completeOrder(){
        prepareFood();
        serveFood();
        System.out.println("주문 완료");
    }


}
