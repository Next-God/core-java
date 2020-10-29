package com.wan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * TopK
 *
 * @author wanyaming
 * @version 1.0
 * 2020/10/13 5:31 下午
 **/
public class ACArray {
    public static void main(String[] args) {
//        int[] arr = {20, 70, 110, 150};
//        int[] ints = twoSum(arr, 90);
//        System.out.println(ints);


        int[] a = {1, 8, 12, 33};
        int[] b = {5, 8, 18, 66};
        int[] C = merge(a, 4, b, 4);

        System.out.println(C);

    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length < k) {
            return new ArrayList();
        }

        ArrayList<Integer> list = new ArrayList();
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers.length < 3) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>(numbers.length, 1);
        for (int i = 0; i < numbers.length; i++) {
            int temp = numbers[i];
            int left = target - temp;
            if (map.containsKey(left)) {
                result[1] = i + 1;
                result[0] = map.get(left) + 1;
            } else {
                map.put(temp, i);
            }


            map.put(numbers[i], i);
        }
        return result;
    }

    /**
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static int[] merge(int A[], int m, int B[], int n) {
        int[] C = new int[m + n];

        int i = 0;
        int j = 0;
        int index = 0;

        while (i < m || j < n) {
            if (i == m || A[i] > B[j]) {
                C[index++] = B[j++];
            } else{
                C[index++] = A[i++];
            }
        }
        return C;
    }
}
