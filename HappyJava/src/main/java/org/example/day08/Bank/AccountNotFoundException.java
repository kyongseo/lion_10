package org.example.day08.Bank;

// 통장 미존재 예외(AccountNotFoundException)
//요청한 계좌 번호의 통장이 존재하지 않을 때 발생
public class AccountNotFoundException extends Exception{

    public AccountNotFoundException(String msg) {
        super(msg);
    }

}
