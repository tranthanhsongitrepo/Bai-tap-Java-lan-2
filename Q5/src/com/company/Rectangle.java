package com.company;

public class Rectangle implements TwoDShape {
    private float a, b;

    @Override
    public float getP() {
        return (a + b) * 2;
    }

    @Override
    public float getS() {
        return a * b;
    }

    @Override
    public int getNoOfPoints() {
        return 4;
    }

    @Override
    public int getNoOfEdge() {
        return 4;
    }

    public Rectangle(float a, float b) {
        this.a = a;
        this.b = b;
    }
}
