package com.wan.lambda;

public class Java8Tester {

    public static void main(String[] args) {
        Java8Tester tester = new Java8Tester();
        System.out.println(tester.operate(5, 10, (a, b) -> a + b));
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    interface MathOperation {
        int operation(int a, int b);
    }
}
