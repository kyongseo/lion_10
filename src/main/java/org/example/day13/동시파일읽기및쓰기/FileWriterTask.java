package org.example.day13.동시파일읽기및쓰기;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterTask implements Runnable{
    @Override
    public void run() {
        try (FileWriter fw = new FileWriter("out.txt",true)) {
            Scanner sc = new Scanner(System.in);

            while (true){
                System.out.print("입력하세요 (0 입력시 종료) : ");
                String input = sc.nextLine();

                if ("0".equals(input)){
                    break;
                }
                fw.write(input + "\n");

            }sc.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
