package org.example.day09.InnerClass;

public class OuterClass {
    private int outerFiled = 10;
    public void outermethod(){
        System.out.println("outermethod 실행!!");

        // 인스턴스 생성
        InnerClass inner = new InnerClass();
        inner.innerMethod();
    }

    class InnerClass{
        public void innerMethod(){
            System.out.println("outerFlied = " + outerFiled);
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.outermethod();
    }
}
