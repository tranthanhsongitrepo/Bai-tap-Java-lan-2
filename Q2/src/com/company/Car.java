package com.company;

import java.util.Scanner;

public class Car extends Vehicles{
    private String engineType;
    private int seats;

    @Override
    public void input(){
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập loại động cơ");
        this.engineType = sc.next();
        System.out.println("Mời nhập số chỗ ngồi");
        this.seats = sc.nextInt();
    }

    @Override
    public Object getFeature(String feature) {
        Object s = super.getFeature(feature);
        if (s != null){
            return  s;
        }

        switch (feature) {
            case "engine type":
                return engineType;
            case "seats":
                return seats;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Loại động cơ: " + this.engineType + '\n' +
                "Số chỗ ngồi: " + this.seats ;

    }
}
