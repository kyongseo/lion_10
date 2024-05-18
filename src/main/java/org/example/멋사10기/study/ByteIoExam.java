package org.example.멋사10기.study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteIoExam {
    public static void main(String[] args) {
        long starttime = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis= new FileInputStream("src/main/java/org/example/멋사10기/study/ByteIoExam.java");
            fos = new FileOutputStream("src/main/java/org/example/멋사10기/study/test.txt");

            int readCount = -1;
            byte[] buffer = new byte[512];
            // read() Method => read()메소드는 byte를 리턴한다면 끝을 나타내는 값을 표현할 수가 없기 때문에, byte가 아닌 int를 리턴한다.
            //음수의 경우 맨 좌측 비트가 1이 된다. 읽어들일 것이 있다면 항상 양수를 리턴한다고볼 수 있다.
            while((readCount = fis.read(buffer)) != -1 ) {
                fos.write(buffer, 0, readCount);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long endtime = System.currentTimeMillis();
        System.out.println(endtime - starttime);

    }
}
