package com.wan.core;

public enum PlantEnum {
    MERCURY(3.302e+23, 2.439e6);

    private final double mass;

    private final double radius;

    private static final double G = 6.67300E-11;

    PlantEnum(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
}
