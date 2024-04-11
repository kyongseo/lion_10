package org.example.day08.Exception.Bank;

// Banker.java
public class Banker {
    private String name;
    private String bankerId;

    public Banker(String name, String bankerId) {
        this.name = name;
        this.bankerId = bankerId;
    }

    public void approveAccount(Account account) {
        System.out.println("은행원 " + name + "에 의해 통장 개설이 완료되었습니다.");
    }

    public void approveWithdrawal(Account account, int amount) {
        System.out.println("은행원 " + name + "에 의해" + amount + "를 출금합니다.");

    }
}
