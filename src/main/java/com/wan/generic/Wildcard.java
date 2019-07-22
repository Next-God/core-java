package com.wan.generic;

import java.util.*;

/**
 * 通配符类型
 */
public class Wildcard {
    public static void main(String[] args) {
        /*Set<String> s1 = new HashSet<>();
        s1.add("123");
        s1.add("22");
        s1.add("31");

        Set<Integer> s2 = new HashSet<>();
        s2.add(666);
        s2.add(2);
        s2.add(new Integer(666));

        getData(s1);
        getData2(s1);

        System.out.println(numElementsInCommon(s1, s2));*/

        List<String> strList = Arrays.asList("a", "b", "c");
        List<Integer> intList = Arrays.asList(1, 2, 3);
        testList(strList);
        testList(intList);

    }

    static <T> T returnByParam(T t) {
        return t;
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

    static <E,T> int numElementsInCommon(Set<E> s1, Set<T> s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    static int numElementsInCommon2(Set s1, Set s2) {
        s1.add(new Object());
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    public static <E> void testList(List<E> list){
        
        list.forEach(System.out::println);
    }


}
