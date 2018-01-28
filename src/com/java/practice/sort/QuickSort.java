package com.java.practice.sort;

/**
 * Created by richard02.zhang on 18/1/26.
 */
public class QuickSort {

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static int partition(int[] arr, int begin, int end) {
        int index = begin;
        int pivot = arr[end];
        for (int i = begin; i < arr.length; i++) {
            if (arr[i] < pivot ) {
                swap(arr, index, i);
                index++;
            }
        }
        swap(arr, end, index);
        return index;
    }

    private static void quickSort(int[] arr, int begin, int end) {
        if (null == arr || arr.length == 0) {
            return;
        }
        if (begin < end) {
            int index = partition(arr, begin, end);
            quickSort(arr, begin, index - 1);
            quickSort(arr, index + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 4, 3, 3, 2, 1};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
