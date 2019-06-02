package com.wan.core;

import java.util.*;

public class ComparableItem {
    public ComparableItem(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    private String name;

    private int age;

    private double height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public static void main(String[] args) {
        List<ComparableItem> items = new ArrayList<>();
        items.add(new ComparableItem("haha", 20, 68.5));
        items.add(new ComparableItem("hehe", 26, 61.5));
        items.add(new ComparableItem("henhen", 32, 72.5));
        PlantEnum.MERCURY.ordinal();

        Map<String, ComparableItem> map = ComparableUtil.listToMap(items, new ComparableUtil.Handler<ComparableItem, String>() {
            @Override
            public String to(ComparableItem arg) {
                return arg.getName();
            }
        });

        //Collections.sort(items);
    }
}
