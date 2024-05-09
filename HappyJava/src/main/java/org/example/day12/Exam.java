package org.example.day12;

public class Exam {

    public static void main(String[] args) {
        int i1= 3;
        int i2 = ++i1;
        System.out.println(i2); //4
        int i3 = i2++;
        System.out.println(i3); //4
        System.out.println(i2); //5
    }
}
