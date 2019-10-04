package com.company;

import java.util.Scanner;

public class Truck extends Vehicles{
    private int load;

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập tải trọng");
        this.load = sc.nextInt();
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Tải trọng: " + this.load;
    }

    @Override
    public Object getFeature(String feature) {
        Object s = super.getFeature(feature);

        if (s != null)
            return s;

        if ("load".equals(feature)) {
            return this.load;
        }
        return null;
    }
}
