package com.company;

import java.util.Scanner;

public class Magazine extends Material{
    private int publishedNumber, publishedMonth;

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Số xuất bản: " + publishedNumber + '\n' +
                "Tháng xuất bản: " + publishedMonth;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.println("Xin mời nhập số xuất bản");
        this.publishedNumber = sc.nextInt();
        System.out.println("Xin mời nhập tháng xuất bản");
        this.publishedMonth = sc.nextInt();
    }

    public Magazine(){
        super();
        this.publishedMonth = this.publishedNumber = 0;
    }
    public Magazine(int publishedNumber, int publishedMonth) {
        super();
        this.publishedNumber = publishedNumber;
        this.publishedMonth = publishedMonth;
    }

    public int getPublishedNumber() {
        return publishedNumber;
    }

    public void setPublishedNumber(int publishedNumber) {
        this.publishedNumber = publishedNumber;
    }

    public int getPublishedMonth() {
        return publishedMonth;
    }

    public void setPublishedMonth(int publishedMonth) {
        this.publishedMonth = publishedMonth;
    }
}
