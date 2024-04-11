package org.example.day07.interfaceTest.Order_Interface;

public class CashPayment implements Payment{
    @Override
    public void processPayment() {
        System.out.println("현금 결제합니다.");

    }
}
