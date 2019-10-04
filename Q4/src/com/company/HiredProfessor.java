package com.company;

import java.util.Scanner;

public class HiredProfessor extends Professor {
    public static final float SALARY_PER_HOUR =  200000f;
    private String company;
    HiredProfessor(){
        super();
        company = null;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Xin mời nhập công ty");
        this.company = sc.nextLine();
    }

    @Override
    public float getSalary(){
        return ((float) this.getTeachingHours())* SALARY_PER_HOUR;
    }
    @Override
    public String toString() {
        return super.toString() + '\n' +
                company ;
    }
}
