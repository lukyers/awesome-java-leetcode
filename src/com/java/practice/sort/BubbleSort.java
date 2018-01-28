package com.java.practice.sort;

/**
 * Created by richard02.zhang on 18/1/26.
 */
public class BubbleSort {

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static void bubbleSort(int[] arr) {
        if (null == arr || 0 == arr.length) {
            return;
        }
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 2, 7, 1, 9, 8};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
