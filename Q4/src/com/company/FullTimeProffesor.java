package com.company;

import java.util.Scanner;

public class FullTimeProffesor  extends Professor {
    public static final float OT_SALARY = 50000f;
    private float baseSalary;
    private int workHourRequirement;

    public FullTimeProffesor(){
        this.baseSalary = 0;
        this.workHourRequirement = 0;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getWorkHourRequirement() {
        return workHourRequirement;
    }

    public void setWorkHourRequirement(int workHourRequirement) {
        this.workHourRequirement = workHourRequirement;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Xin mời nhập lương thỏa thuận");
        this.baseSalary = sc.nextFloat();
        System.out.println("Xin mời nhập giờ làm tối thiểu");
        this.workHourRequirement = sc.nextInt();
    }

    @Override
    public float getSalary(){
        float res = baseSalary;
        if (workHourRequirement < this.getTeachingHours())
            res += (this.getTeachingHours() - this.workHourRequirement) * OT_SALARY;
        return res * this.getSalaryMultiplier();
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Lương thỏa thuận: " + baseSalary + '\n' +
                "Giờ thỏa thuận: " + workHourRequirement;
    }


}
