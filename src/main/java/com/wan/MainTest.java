package com.wan;

public class MainTest {
    public static void main(String[] args) {
        try {
            throw new RuntimeException("aHa");
        } catch (RuntimeException e) {

        }
    }
}
