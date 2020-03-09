package com.wan.sort;

/*
 * 插入排序
 */
public class InsertSort extends AbstractSort {
    public static void main(String[] args) {
        for (int i = 1; i < length; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >=0; j--) {
                if (array[j] > value) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = value;
        }

        print();
    }
}
