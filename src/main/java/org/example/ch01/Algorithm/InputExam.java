package org.example.ch01.Algorithm;

import java.util.Scanner;

/**
 * ** Scanner 클래스의 입력 메소드들 **
 * 1. nextInt() : 정수 (int) 타입의 데이터를 읽어들입니다.
 * 2. nextLong() : 긴 정수 (long) 타입의 데이터를 읽어들입니다.
 * 3. nextFloat() : 부동 소수점 (float) 타입의 데이터를 읽어들입니다.
 * 4. nextDouble() : 더블 정밀도의 부동 소수점 (double) 타입의 데이터를 읽어들입니다.
 * 5. nextBoolean() : 불리언 (boolean) 타입의 데이터를 읽어들입니다. 이 메소드는
 * 6. nextByte() : 바이트 (byte) 타입의 데이터를 읽어들입니다.
 * 7. nextShort() : 짧은 정수 (short) 타입의 데이터를 읽어들입니다.
 * 8. next() : 다음 토큰을 문자열로 읽어들입니다. 이 메소드는 공백으로 구분된 단어를 반환합니다.
 * 9. nextLine() : 줄의 끝까지 문자열을 읽어들입니다. 이 메소드는 한 줄 전체를 입력으로 받으며, 줄바꿈 문자를 읽은 후에 제거합니다
 */
public class InputExam {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // 키보드로 입력받은 값은 String 타입이라 형변환 필수
        System.out.println("정수 입력");
        int num = sc.nextInt();

        // 입력 버퍼 바꾸기
        sc.nextLine();

        System.out.println("문지열을 입력");
        String text = sc.nextLine();

        System.out.println(num);
        System.out.println(text);

        // Scanner 객체 닫기
        sc.close();
    }
}
