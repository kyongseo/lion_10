package org.example.day08.Exception;

public class ExceptionExam4 {

    // 예외 던지기
    public static void 심부름() throws Exception{
        System.out.println("심부름 시작");

        int i =0;

        System.out.println(10/i);

        System.out.println("심부름 끝");
    }
    public static void main(String[] args) {
        // 엄마가 심부름 시킴
        try {
            심부름();
        } catch (Exception e) {
            System.out.println("동생에게 시킴");
        }
    }
}
