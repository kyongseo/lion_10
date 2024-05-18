package org.example.멋사10기.study;

public class MyClassExam {

    int globalNum = 10;
    static int staticNum = 20;

    public void scopeTest(int value){
        int scopeNum = 40;
        System.out.println("value : " + value);
        System.out.println("scopeNum : " + scopeNum);
        System.out.println("globalNum : " + globalNum);
    }
    public static void main(String[] args) {
        System.out.println("staticNum : " + staticNum);

        MyClassExam myClassExam = new MyClassExam();
        myClassExam.scopeTest(60);

        int gl = myClassExam.globalNum =100;
        System.out.println("gl : " + gl);

        System.out.println("globalNum : " + myClassExam.globalNum);

        MyClassExam myClassExam2 = new MyClassExam();
        myClassExam.globalNum = 200;
        myClassExam2.globalNum = 300;
        System.out.println(myClassExam.globalNum);
        System.out.println(myClassExam2.globalNum);

        System.out.println("======================================");

        myClassExam.staticNum = 400;
        myClassExam2.staticNum = 500;
        System.out.println(myClassExam.staticNum);
        System.out.println(myClassExam2.staticNum);

//        MyClass myClass = new MyClass();
//        myClass.method1();
//        myClass.method2(10);
//        int method3 = myClass.method3();
//        System.out.println(method3);
//        myClass.method4(10,20);
//        myClass.method5(20,30);
    }
}
