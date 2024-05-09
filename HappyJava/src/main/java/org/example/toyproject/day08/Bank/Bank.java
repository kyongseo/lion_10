package org.example.toyproject.day08.Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private String bankName;
    //private List<Account> accounts;
    private Map<String, Account> accounts;

    public Bank(String name) {
        this.bankName = name;
     //   this.accounts = new ArrayList<>();
        this.accounts = new HashMap<>();
    }

    // 통장개설 -> 리스트 형태로 저장
    public void addAccount(Account accountNumber) {

        accounts.put(accountNumber.getAccountNumber(), accountNumber);;
    }

    // 특정 통장 정보조회
    public Account getAccount(String accountNumber) throws AccountNotFoundException {

        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber);
        }
        throw new AccountNotFoundException(accountNumber + " 통장을 찾을 수 없습니다." );
    }

    //        for (Account account : accounts) {
//            if (account.getAccountNumber().equals(accountNumber)) {
//                return account;
//            }
//        }
//        throw new AccountNotFoundException(accountNumber + " 통장을 찾을 수 없습니다." );
//    }

}
