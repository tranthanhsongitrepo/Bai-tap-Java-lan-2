package com.company;

public class Square implements TwoDShape {
    private float a;

    public Square(float a) {
        this.a = a;
    }

    @Override
    public float getP() {
        return 4f * a;
    }

    @Override
    public float getS() {
        return a * a;
    }

    @Override
    public int getNoOfPoints() {
        return 4;
    }

    @Override
    public int getNoOfEdge() {
        return 4;
    }
}
