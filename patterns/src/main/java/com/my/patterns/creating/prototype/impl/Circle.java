package com.my.patterns.creating.prototype.impl;

import com.my.patterns.creating.prototype.Shape;

public class Circle extends Shape {
    private int radius;

    public Circle(int a, int b, String color, int radius) {
        super(a, b, color);
        this.radius = radius;
    }

    @Override
    public Circle clone() {
        return new Circle(this.a, this.b, this.color, this.radius);
    }
}
