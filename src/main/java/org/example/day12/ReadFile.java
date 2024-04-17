package org.example.day12;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        // "test.txt" 파일에서 한 줄 씩 입력받아서 입력받은 문자 뒤에 hi를 추가해서 파일에 출력하는 프로그램을 작성해보세요.
        // "testhi.txt" 파일에 출력하는 프로그램을 작성해보세요.
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"));
             PrintWriter  bw = new PrintWriter ("testhi.txt")) {

            String str;
            while ((str = br.readLine()) != null) {
                bw.write(str + "hi");
                bw.write("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
