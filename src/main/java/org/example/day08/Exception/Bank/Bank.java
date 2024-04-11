package org.example.day08.Exception.Bank;

// Bank.java
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String BankName;
    private List<Account> accounts;

    public Bank(String name) {
        this.BankName = name;
        this.accounts = new ArrayList<>();
    }

    // 통장 개설
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // 특정 통장 정보 조회
    public Account getAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException("통장을 찾을 수 없습니다: " + accountNumber);
    }
}
