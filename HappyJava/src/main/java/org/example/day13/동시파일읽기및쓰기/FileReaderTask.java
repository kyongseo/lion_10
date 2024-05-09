package org.example.day13.동시파일읽기및쓰기;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTask implements Runnable{
    String line;

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))){

            while ((line != null)){
                System.out.println(line);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
