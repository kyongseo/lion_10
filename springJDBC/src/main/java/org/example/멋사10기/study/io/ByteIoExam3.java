package org.example.멋사10기.study.io;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * 다양한 타입의 입력
 * date.txt로부터 값을 읽어들여 화면에 출력하는 클래스
 *
 * 다양한 타입의 데이터를 읽어낼 수 있는 DataInputStream
 */
public class ByteIoExam3 {

    public static void main(String[] args) {

        try(DataInputStream in = new DataInputStream(new FileInputStream("date.txt"))
        ){
            int i = in.readInt();
            boolean b = in.readBoolean();
            double d = in.readDouble();
            int sum;
            sum = i;
            System.out.println(i);
            System.out.println(b);
            System.out.println(d);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    public static int read3(){
//        int sum = 0;
//        //data.txt로부터 int값 3개를 읽어들여서 sum에 더하세요.
//        try(DataInputStream in = new DataInputStream(new FileInputStream("data.txt")))
//        {
//            int num=-1;
//            while((num = in.readInt())!=-1){
//                sum+=num;
//            }
//        } catch(Exception ex){
//            ex.printStackTrace();
//        }

    }
