package org.example.멋사10기.study.lambda;

/**
 * 람다식 기본문법
 * (매개변수목록)->{실행문}
 *
 * 2개의 값을 비교하여 어떤 값이 더 큰지 구하는 compareTo()라는 메소드를 가지고 있는 Compara 인터페이스
 * 2개의 값을 받아들인 후, 정수를 반환하는 메소드를 선언
 *
 * 자바는 메소드만 인자로 전달하려면 반드시 객체를 만들어서 전달해야 했다. Java8에 람다식이 생기면서, 마치 함수만 전달하는 것처럼 간편하게 문법을 사용할 수 있게 되다.
 */
public class CompareExam  {

    public static void exec(Compare compare){
        int k =10;
        int m = 20;
        int value = compare.compareTo(k,m);
        System.out.println(value);
    }

    public static void main(String[] args) {
        exec((i,j)-> {
            return i - j;
        });
    }
}
