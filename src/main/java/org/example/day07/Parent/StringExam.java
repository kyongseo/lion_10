package org.example.day07.Parent;

public class StringExam {

    public static void main(String[] args) {
        /**
         * case 1
         * 다 같은 주소를 지정
         */
        String str1 = "hello";
        String str2 = "hello";

        /**
         * case2
         * 각각의 주소로 할당
         */
        String str3 = new String("hello");
        String str4 = new String("hello");

        /**
         *  == 는 주소를 비교해주는 것
         *  equals 는 해당 객체의 값을 비교해주는 것
         */
        if (str1 == str2) {
            System.out.println("같아요");
        } else {
            System.out.println("달라요");
        }
        if (str3 == str4) {
            System.out.println("같아요");
        } else {
            System.out.println("달라요");
        }

        if (str1 == str3){
            System.out.println("같아요");
        } else {
            System.out.println("달라요");
        }

        if (str1.equals(str3)){
            System.out.println("같아요");
        } else {
            System.out.println("달라요");
        }

        System.out.println(str1.concat(" kyongseo!"));
        System.out.println(str1);

        System.out.println(str1 = str1.concat(" kyongseo!!"));
        System.out.println(str1);

    }
}
