package org.example.day08.Bank;

public class Account {
    private String accountNumber;
    private String accountName;
    private int balance; // 잔액

    public Account(String accountNumber, String accountName, int balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println(amount + "원이 입금되어 " + balance + "원이 되었습니다.");
    }

    public void withdraw(int amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("잔액이 부족합니다.");
        }
        balance -= amount;
        System.out.println(amount + "원을 출금하여 " + balance + "원이 되었습니다.");
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getBalance() {
        return balance;
    }
}
