package com.company;

public class Sphere implements ThreeDShape {
    private float r;

    @Override
    public float getS() {
        return (float) (4 * Math.PI * r * r);
    }

    @Override
    public float getSurroundS() {
        return getS();
    }

    public Sphere(float r) {
        this.r = r;
    }
}
