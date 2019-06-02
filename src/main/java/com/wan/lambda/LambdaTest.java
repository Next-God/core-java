package com.wan.lambda;

import java.util.*;

import static java.util.Comparator.comparingInt;

public class LambdaTest {
    public static void main(String[] args) {
        List<String> wordsList = new ArrayList<>();
        wordsList.add("3");
        wordsList.add("8");
        wordsList.add("53");
        wordsList.add("16");
        //Collections.sort(wordsList, (s1, s2) -> Integer.compare(s1, s2));
        Collections.sort(wordsList, comparingInt(String::length));
        wordsList.forEach(System.out::println);

        wordsList.sort(comparingInt(String::length));

        //test(str -> Integer.parseInt(str));

        Map<String, String> map = new HashMap<>();
        map.merge("12", "", (count, incr) -> count + incr);

        //set不起作用啊
    }

    private static void test(Integer a){}
}
