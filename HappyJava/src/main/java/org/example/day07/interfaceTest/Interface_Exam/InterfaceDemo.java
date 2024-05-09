package org.example.day07.interfaceTest.Interface_Exam;

public class InterfaceDemo {
    public static void main(String[] args) {


        Ainter a = new AImpl();
        a.aMethod();
        a.same();
        ((AImpl)a).say(); // 타입이 아는 것까지만 쓸 수 있고, 외의 것을 쓰고 싶다면 형변환이 필수
    }
}
