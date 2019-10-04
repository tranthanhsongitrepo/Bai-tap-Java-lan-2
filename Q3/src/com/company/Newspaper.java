package com.company;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Newspaper extends Material {
    private Date publishedDate;

    @Override
    public String toString() {
        return super.toString() + '\n' +
                publishedDate.toString();
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        int date, year, month;
        System.out.println("Xin mời nhập ngày");
        date = sc.nextInt();
        sc.nextLine();
        System.out.println("Xin mời nhập tháng");
        month = sc.nextInt();
        sc.nextLine();
        System.out.println("Xin mời nhập năm");
        year = sc.nextInt();
        sc.nextLine();
        this.publishedDate = new Date(year, month - 1, date);
    }

    public Newspaper(){
        super();
        this.publishedDate = null;
    }
    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public Newspaper(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}
