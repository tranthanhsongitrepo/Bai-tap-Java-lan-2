package com.company;

import java.util.Scanner;

public class Motorbike extends Vehicles {
    private int horsePower;

    @Override
    public void input(){
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập phân khối");
        this.horsePower = sc.nextInt();
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Phân khối: " + horsePower;
    }

    @Override
    public Object getFeature(String feature) {
        Object s = super.getFeature(feature);

        if (s != null)
            return s;

        if ("horse power".equals(feature)) {
            return this.horsePower;
        }
        return null;
    }
}
