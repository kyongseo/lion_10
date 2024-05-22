package org.example.멋사10기.study;

import java.lang.reflect.Method;

public class MyHelloExam {
    public static void main(String[] args) {
        MyHello hello = new MyHello();

        try{
            Method method = hello.getClass().getDeclaredMethod("hello");
            if(method.isAnnotationPresent(Count100.class)){
                for(int i = 0; i < 10; i++){
                    hello.hello();
                }
            }else{
                hello.hello();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}