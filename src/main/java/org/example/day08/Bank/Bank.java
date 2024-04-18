package org.example.day08.Bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private List<Account> accounts;

    public Bank(String name) {
        this.bankName = name;
        this.accounts = new ArrayList<>();
    }

    // 통장개설 -> 리스트 형태로 저장
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // 특정 통장 정보조회
    public Account getAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException(accountNumber + " 통장을 찾을 수 없습니다." );
    }
}
