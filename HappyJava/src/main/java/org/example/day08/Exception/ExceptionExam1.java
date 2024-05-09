package org.example.day08.Exception;

import java.beans.PropertyEditorSupport;

public class ExceptionExam1 {

    public static void main(String[] args) {
        int[] arr ={1,2,3};

        try{
            int result = 10/0;
            System.out.println(arr[3]);

            System.out.println("거울을 본다.");

        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("arr[3]은 없습니다. arr[0]의 값을 출력합니다. arr[0] : " + arr[0]);
            System.out.println(e.getMessage());

//        }catch (ArithmeticException e){
//            System.out.println(e.toString());
//            System.out.println(e.getMessage());
//            e.printStackTrace();

        }catch (Exception e) {
          //  System.out.println(e.toString());
          //  System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("다음 문장1");
        System.out.println("다음 문장2");
        System.out.println("다음 문장3");
        System.out.println("end");


    }
}
