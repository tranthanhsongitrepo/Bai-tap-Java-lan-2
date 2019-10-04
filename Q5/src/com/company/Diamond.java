package com.company;

public class Diamond implements TwoDShape {
    private float a, d;
    @Override
    public float getP() {
        return a * 4;
    }

    @Override
    public float getS() {
        return 0.5f * d * d;
    }

    @Override
    public int getNoOfPoints() {
        return 4;
    }

    @Override
    public int getNoOfEdge() {
        return 4;
    }

    public Diamond(float a, float d) {
        this.a = a;
        this.d = d;
    }
}
