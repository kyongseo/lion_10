package org.example.day07.interfaceTest.Order_Interface;

public class OrderSystemDemo {
    public static void main(String[] args) {

        Order pizzaorder = new PizzaOrder();
        pizzaorder.completeOrder();

        Payment creditPay = new CreditPayment();
        creditPay.processPayment();
    }
}
