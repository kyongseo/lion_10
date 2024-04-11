package org.example.day08.Exception.Bank;

//잔액 부족 예외(InsufficientFundsException)
//출금 금액이 잔액을 초과할 때 발생
public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}
