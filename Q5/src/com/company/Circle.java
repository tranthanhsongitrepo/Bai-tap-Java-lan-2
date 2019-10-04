package com.company;

public class Circle implements TwoDShape{
    private float r;

    @Override
    public float getP() {
        return (float) (Math.PI * r * 2f);
    }

    @Override
    public float getS() {
        return (float) (Math.PI * r * r);
    }

    @Override
    public int getNoOfPoints() {
        return -1;
    }

    @Override
    public int getNoOfEdge() {
        return -1;
    }

    public Circle(float r) {
        this.r = r;
    }
}
