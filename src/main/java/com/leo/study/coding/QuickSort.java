package com.leo.study.coding;

/**
 * @author chao.li@quvideo.com
 * @date 2019/12/11 20:31
 */
public class QuickSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int i = partition(arr, low, high);
            sort(arr, low, i - 1);
            sort(arr, i + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int x = arr[low];
        int i = low, j = high;
        while (i < j) {
            while (i < j && arr[j] >= x) {
                j--;
            }
            while (i < j && arr[i] <= x) {
                i++;
            }

            if (i != j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, i);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 8, 9};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
