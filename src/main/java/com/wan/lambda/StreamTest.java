package com.wan.lambda;

import com.wan.model.Student;
import com.wan.util.InitData;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        //初始化List数据同上
        List<Student> list = InitData.getStudents();
        list.forEach(System.out::println);

        //使用map方法获取list数据中的name
        List<String> names = list.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(names);

        //使用map方法获取list数据中的name的长度
        List<Integer> length = list.stream().map(Student::getName).map(String::length).collect(Collectors.toList());
        System.out.println(length);

        //将每人的分数-10
        List<Integer> score = list.stream().map(Student::getScore).map(i -> i - 10).collect(Collectors.toList());
        System.out.println(score);

        //计算学生总分
        Integer totalScore1 = list.stream().map(Student::getScore).reduce(0,(a,b) -> a + b);
        System.out.println(totalScore1);

        //计算学生总分，返回Optional类型的数据，改类型是java8中新增的，主要用来避免空指针异常
        Optional<Integer> totalScore2 = list.stream().map(Student::getScore).reduce((a, b) -> a + b);
        System.out.println(totalScore2.get());

        //计算最高分和最低分
        Optional<Integer> max = list.stream().map(Student::getScore).reduce(Integer::max);
        Optional<Integer> min = list.stream().map(Student::getScore).reduce(Integer::min);

        System.out.println(max.get());
        System.out.println(min.get());
    }
}
