package com.wan.lambda;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;

public class CollectorTest {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,5);
        List<Integer> list2 = Arrays.asList(1,2,5,7);

        //交集
        List<Integer> intersect =list1.stream().filter(list2::contains).collect(toList());
        System.out.println(intersect);

        //差集
        //(list1 - list2)
        List<Integer> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(toList());
    }
}
