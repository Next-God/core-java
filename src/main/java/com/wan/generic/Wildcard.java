package com.wan.generic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 通配符类型
 */
public class Wildcard {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        s1.add("123");
        s1.add("22");
        s1.add("31");

        Set<Integer> s2 = new HashSet<>();
        s2.add(666);
        s2.add(2);
        s2.add(new Integer(666));

        getData(s1);
        getData2(s1);

        //System.out.println(numElementsInCommon(s1, s2));
    }

    static void getData(Set<?> set) {
        for (Object element : set) {
            System.out.println(element);
        }
    }

    static <E> void getData2(Set<E> set){
        for (E element : set) {
            System.out.println(element);
        }
    }

    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        /*不能add
        s2.add(12);*/
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    static <E> void swapHelper(List<E> list, int i, int j) {

    }


}
