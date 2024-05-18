package org.example.멋사10기.study;

import java.io.*;

/**
 * 다양한 타입의 출력
 * try-with-resources 블럭 선언
 * java io객체는 인스턴스를 만들고, 모두 사용하면 close()메소드를 호출해야 한다.
 * close()메소드를 사용자가 호출하지 않더라도, Exception이 발생하지 않았다면 자동으로 close()가 되게 할 수 있는 방법
 *
 * 다양한 타입으로 저장 할 수 있는 DataOutputStream
 */
public class ByteIoExam2 {
    public static void main(String[] args) {

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("date.txt")))
        {
            out.writeInt(1);
            out.writeBoolean(true);
            out.writeDouble(50.5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
