package org.example.ch01.Algorithm;

public class BinaryExam {
    public static void main(String[] args) {
        int decimal = 29;

        // StringBuilder 는 String 과 문자열을 더할 때 새로운 객체를 생성하는 것이 아니라 기존의 데이터에 더하는 방식을 사용하기 때문에 속도도 빠르며 상대적으로 부하가 적다.
        // 따라서 긴 문자열을 더하는 상황이 발생할 경우 StringBuffer 또는 StringBuilder 사용
        StringBuilder binary = new StringBuilder();

        while(decimal > 0){
            int remainder = decimal % 2;
            decimal = decimal / 2;
            System.out.println(remainder);
            binary.append(remainder);
        }
        System.out.println(binary.reverse().toString());
    }
}
