package com.wan.sort;

/*
 * 插入排序
 */
public class InsertSort extends AbstractSort {
    public static void main(String[] args) {
        for (int i = 1; i < length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >=0; j--) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = value;
        }

        print();
    }
}
