package org.example.day08.Bank;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 은행 생성
        Bank bank = new Bank("멋사");

        // 은행원 생성
        Banker banker = new Banker("ks", "12345");

        // 통장 생성 및 개설
        Account account1 = new Account("101", "개구리", 100000);

        // 통장 은행에 등록
        bank.addAccount(account1);

        account1.deposit(200000);

        try {
            account1.withdraw(100000);

        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
