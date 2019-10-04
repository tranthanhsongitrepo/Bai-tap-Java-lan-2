package com.company;

public class Parallelogram implements TwoDShape {
    private float a, b, h;

    @Override
    public float getP() {
        return (a + b) * 2;
    }

    @Override
    public float getS() {
        return a * h;
    }

    @Override
    public int getNoOfPoints() {
        return 4;
    }

    @Override
    public int getNoOfEdge() {
        return 4;
    }

    public Parallelogram(float a, float b, float h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }
}
