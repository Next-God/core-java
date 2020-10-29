package com.wan.sort;

public abstract class AbstractSort {
    public static int[] arr = {32, 22, 66, 78, 1, 42, 28, 96, 15};
    public static int length = arr.length;

    public static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void print() {
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
