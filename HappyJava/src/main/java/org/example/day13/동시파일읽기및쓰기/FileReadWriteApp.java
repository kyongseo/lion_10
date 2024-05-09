package org.example.day13.동시파일읽기및쓰기;

public class FileReadWriteApp {

    public static void main(String[] args) {
        Thread read = new Thread(new FileReaderTask());
        Thread write = new Thread(new FileWriterTask());

        read.start();
        write.start();
    }
}
