package org.example.day08.Exception;

public class MyException extends RuntimeException{
    public MyException() {
        super("점수는 0-100점까지만 입력 받을 수 있습니다.");
    }

    public MyException(String msg) {
        super(msg);
    }
}
