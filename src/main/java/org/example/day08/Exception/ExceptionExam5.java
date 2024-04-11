package org.example.day08.Exception;

public class ExceptionExam5 {
    public static void main(String[] args) {
        int[] arr ={1,2,3};
        try{
            System.out.println("try start");

            int result = 10 / 2;
            System.out.println(arr[2]);

            arr = null;
            System.out.println(arr[0]);

            System.out.println("try end");

        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException catch block");
            System.out.println(e.getMessage());

        }catch (NullPointerException e) {
            System.out.println("NullPointerException catch block");
            System.out.println(e.getMessage());

        }finally {
            System.out.println("반드시 실행됨");
        }

        System.out.println("다음 문장1");
        System.out.println("다음 문장2");
        System.out.println("다음 문장3");
        System.out.println("end~!");
    }
}
