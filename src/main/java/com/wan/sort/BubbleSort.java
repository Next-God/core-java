package com.wan.sort;

/*
 * 冒泡排序
 *
 * 1.原地排序
 * 2.稳定排序
 * 3.时间复杂度O
 */
public class BubbleSort extends AbstractSort {
    public static void main(String[] args) {
        for (int i = 0; i < length; i++) {

            // 这里的两个取值要注意下
            for (int j = i + 1; j < length - i - 1; j++) {
                if (arr[i] > arr[j]) swap(i, j);
            }
        }

        print();
    }
}
