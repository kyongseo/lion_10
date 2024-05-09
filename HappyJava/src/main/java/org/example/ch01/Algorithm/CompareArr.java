package org.example.ch01.Algorithm;

public class CompareArr {

    static boolean ArrEqual(int[] arr1, int[] arr2){
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5};
        int arr2[] = {1,2,3,4,5};
        int arr3[] = {1,2,3,4};

        // areArraysEqual 메소드를 사용하여 배열 비교
        System.out.println("array1과 array2는 동일한가? " + ArrEqual(arr1, arr2));
        System.out.println("array1과 array3는 동일한가? " + ArrEqual(arr1, arr3));
    }
}
