package com.company;

public class Cylinder implements ThreeDShape{
    float r, h;

    @Override
    public float getS() {
        return (float) (getSurroundS() + 2 * Math.PI * r * r);
    }

    @Override
    public float getSurroundS() {
        return (float) (h * 2 * r * Math.PI);
    }

    public Cylinder(float r, float h) {
        this.r = r;
        this.h = h;
    }
}
