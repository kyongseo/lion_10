package org.example.day10;

public class GenericMethodExam {
    // T 타입은 Number만 상속받고 max라는 T 타입으로 반환하는 메소드 생성
    public static <T extends Number> T max(T x, T y, T z) {
        T max = x;

        if (y.doubleValue() > max.doubleValue()){
            max = y;
        }
        if (z.doubleValue() > max.doubleValue()) {

            max = z;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(max(3,4,5));
        System.out.println(max(6,8,2));
        System.out.println(max(19,4,2));

        System.out.println(max(5.6,2.4,3.9));
    }
}
