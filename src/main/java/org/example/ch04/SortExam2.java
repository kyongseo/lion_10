package org.example.ch04;

import java.util.Arrays;

public class SortExam2 {
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i; j < n; j++) {
                if(arr[min] > arr[j])    min = j;
            }
            swap(arr, i, min);
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,5,7,1,8};

        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
