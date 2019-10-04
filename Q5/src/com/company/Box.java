package com.company;

public class Box implements ThreeDShape {
    private float a;
    private float b;

    @Override
    public float getS() {
        return a * b * c;
    }

    @Override
    public float getSurroundS() {
        return 2 *(a * b + b * c + c * a);
    }

    public Box(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    float c;
}
