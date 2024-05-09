package org.example.day09.InnerClass;

public class StaticExam {

    int i =10;
    static int si = 20;

    public void ma() {
        System.out.println(i);
        System.out.println(si);
        System.out.println("sm을 호출합니다.");
        sm();
    }
    public static void sm(){
        // System.out.println(i); // 불가능
        System.out.println("sm함수 안에서 si의 값을 호출합니다.");
        System.out.println(si);
    }

    public static void main(String[] args) {
        StaticExam exam = new StaticExam();
        exam.ma();
    }
}
