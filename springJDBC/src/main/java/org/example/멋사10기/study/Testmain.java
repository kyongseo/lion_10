package org.example.멋사10기.study;

public class Testmain {
    public static void main(String[] args) {
        Test test = new Test();
        test.name = "park";
        test.number = "1111";
        test.year =2001;

        Test test2 = new Test();
        test2.name = "park";
        test2.number = "1111";
        test2.year =2001;

        // 오버라이드 하면 같다, 안하면 다르다가 나오네..?
        if (test.equals(test2)) {
            System.out.println("test is equal");
        }else {
            System.out.println("test is not equal");
        }

        if (test.name.equals(test2.name)) {
            System.out.println("test name is equal");
        } else {
            System.out.println("test name is not equal");
        }
    }
}
