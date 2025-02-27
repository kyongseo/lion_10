package org.example.멋사10기.study.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Char 단위 입출력(Console)
 * char단위 입출력 클래스는 클래스 이름이 Reader나 Writer로 끝이 납니다.
 *
 * char단위 입출력 클래스를 이용해서 키보드로 부터 한줄 입력 받아서 콘솔에 출력
 * System.in - 키보드를 의미 (InputStream )
 * BufferedReader - 한줄씩 입력 받기위한 클래스
 * BufferedReader 클래스의 생성자는 InputStream을 입력받는 생성자가 없다.
 * System.in은 InputStream 타입이므로 BufferedReader의 생성자에 바로 들어갈 수 없으므로 InputStreamReader 클래스를 이용해야함.
 */
public class CharExam {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(line);
    }
}
