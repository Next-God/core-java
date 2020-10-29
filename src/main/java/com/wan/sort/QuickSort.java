package com.wan.sort;

/**
 * QuickSort
 *
 * @author wanyaming
 * @version 1.0
 * 2020/10/13 2:57 下午
 **/
public class QuickSort extends AbstractSort {
    public static void main(String[] args) {
        quickSort(0, length - 1);
        print();
    }

    private static void quickSort(int low, int high) {
        if (low < high) {
            // 找寻基准数据的正确索引
            int index = partition(low, high);

            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            //quickSort(arr, 0, index - 1); 之前的版本，这种姿势有很大的性能问题，谢谢大家的建议
            quickSort(low, index - 1);
            quickSort(index + 1, high);
        }
    }

    private static int partition(int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }
}
