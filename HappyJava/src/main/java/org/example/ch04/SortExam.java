package org.example.ch04;

import java.util.Arrays;

/**
 * BubbleSort
 */
public class SortExam  {

    //--- 단순 교환 정렬(버블 정렬)을 수행합니다 ---//
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println(i+1 +"번째 : " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] array = {6,3,4,7,2,5}; //6

        bubbleSort(array);
        System.out.println("최종 정렬 : " + Arrays.toString(array));
    }
}
