package com.wan.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Tester {

    public static void main(String[] args) {
        /*Java8Tester tester = new Java8Tester();
        System.out.println(tester.operate(5, 10, (a, b) -> a + b));*/

        Map<String, String> groups = new HashMap<>();
        groups.put("aaa", "AAA");
        groups.put("bbb", "BBB");

        groups.computeIfPresent("aaa", (key, value) -> ("*ST" + value));
        groups.computeIfAbsent("ccc", key -> "CCC");

        /*List<String> list = Arrays.asList("1", "2", "aaa");
        list.stream().collect(Collectors.groupingBy())*/

        System.out.println(groups);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    interface MathOperation {
        int operation(int a, int b);
    }
}
