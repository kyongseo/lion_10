package org.example.day08.Exception.Bank;

public class BankMain {
    public static void main(String[] args) {
        // 은행 생성
        Bank bank = new Bank("멋사");

        // 은행원 생성
        Banker banker = new Banker("ks", "12345");

        // 통장 생성 및 개설
        Account account1 = new Account("101", "개구리", 500000);

        // 통장 은행에 등록
        bank.addAccount(account1);

        try {
            account1.withdraw(100000);

        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            Account aliceAccount = bank.getAccount("101");
            System.out.println("통장번호 " + aliceAccount.getAccountNumber() +"번 " + aliceAccount.getAccountName() + " 고객님의 현재 남은 잔액은 " + aliceAccount.getBalance());

        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
