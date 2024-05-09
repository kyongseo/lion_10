package org.example.day10;

public class GenericMethod {

    public static <T> void printArray(T[] array){
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Integer[] iArray = {1,2,3,4,5,6};
        printArray(iArray);

        String[] strArray = {"a","b","c"};
        printArray(strArray);
    }
}
