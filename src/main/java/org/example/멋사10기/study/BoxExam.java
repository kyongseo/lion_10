package org.example.멋사10기.study;

public class BoxExam {
    public static void main(String[] args) {
        Box box = new Box();
        box.setObj(new Object()); // Object someObject = new Object(); box.setObj(someObject);
        Object obj = box.getObj();
        System.out.println(obj);

        box.setObj(1);
        int value = (int) box.getObj();
        System.out.println(value);


    }
}
