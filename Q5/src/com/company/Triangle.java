package com.company;

public class Triangle implements TwoDShape {
    private float a, b, c;

    @Override
    public float getP() {
        return a + b + c;
    }

    @Override
    public float getS() {
        float p = a + b + c;
        return (float) Math.sqrt(p * (p - a) *(p - b) * (p - c));
    }

    @Override
    public int getNoOfPoints() {
        return 3;
    }

    @Override
    public int getNoOfEdge() {
        return 3;
    }

    public Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
