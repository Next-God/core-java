package com.wan.sort;

public abstract class AbstractSort {
    public static int[] array = {32, 22, 66, 78, 1, 42, 28, 96, 15};
    public static int length = array.length;

    public static void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void print() {
        for (int num : array) {
            System.out.println(num);
        }
    }
}
