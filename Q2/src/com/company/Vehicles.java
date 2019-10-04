package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Vehicles {
    protected String brand, color;
    protected int year;
    protected float price;

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập hãng");
        brand = sc.nextLine();
        System.out.println("Mời nhập năm");
        year = sc.nextInt();
        System.out.println("Mời nhập giá");
        price = sc.nextFloat();
        System.out.println("Mời nhập màu");
        sc.nextLine();
        color = sc.nextLine();
    }

    public Object getFeature(String feature){
            switch (feature){
                case "brand":
                    return brand;
                case "color":
                    return color;
                case "year":
                    return year;
                case "price":
                    return price;
                default:
                    return null;
            }
    }
    @Override
    public String toString() {
        return
                "Hãng: " + brand + '\n' +
                "Màu: " + color + '\n' +
                "Năm:" + year + '\n' +
                "Giá:" + price;
    }

}
