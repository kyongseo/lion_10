package org.example.day08.Final;

public class Main {
    public static void main(String[] args) {
        //final 클래스
        String encryptionKey = SecurityConfig.getEncryptionKey();
        System.out.println(encryptionKey);

        //final 필드
        Person person = new Person(1001, "ks");
        System.out.println("사람의 id : " + person.getId());
        System.out.println("사람의 이름 : " + person.getName());

        person.setName("jane");
        System.out.println("변경된 이름 : " + person.getName());

        // final 메서드
        BankAccount account = new BankAccount(12345,1000.0);
        System.out.println(account.getAccountINfo());

        account.deposit(500);
        System.out.println(account.getAccountINfo());

        account.withdraw(200);
        System.out.println(account.getAccountINfo());
    }
}
