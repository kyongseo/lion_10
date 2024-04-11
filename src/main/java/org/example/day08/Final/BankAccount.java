package org.example.day08.Final;

// final 메서드
public class BankAccount {
    // 계좌 번호 => final 로 선언되어 있으며, 한 번 설정된 후 변경할 수 없습니다
    private final int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // final 메소드는 계좌의 정보를 문자열 형태로 반환
  public final String getAccountINfo() {
        return "계좌번호 : " + accountNumber + " 잔액: " + balance;
  }

  public void deposit(double amount){
        balance += amount;
  }

  public void withdraw(double amount) {
        balance -= amount;
  }
}
