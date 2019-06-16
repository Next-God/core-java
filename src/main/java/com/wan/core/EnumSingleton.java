package com.wan.core;

public class EnumSingleton {

    private EnumSingleton() {
    }

    public static EnumSingleton getInstance() {
        return Singleton.INSTANCE.enumSingleton;
    }

    private enum Singleton {
        INSTANCE;
        private EnumSingleton enumSingleton;

        Singleton() {
            enumSingleton = new EnumSingleton();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(EnumSingleton.getInstance());
        }
    }
}
