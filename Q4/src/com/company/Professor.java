package com.company;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Professor {
    public static final String[] LEVELS = {"Đại học", "Thạc sĩ", "Tiến sĩ"};
    public static final String[] RANKS = {"Không", "Giáo sư", "Phó giáo sư"};
    public static final float[] SALARY_MULTIPLIERS = {1, 1.1f, 1.2f};

    private String id, name, email, ad, phone;
    private int teachingHours, rank, level;
    private float salaryMultiplier;

    public Professor(){
        this.id = this.name = this.email  = this.ad = this.phone = null;
        this.teachingHours = this.rank = this.level = 0;
        this.salaryMultiplier = 0f;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Xin mời nhập ID");
            this.id = sc.nextLine().trim().toUpperCase();
        } while (!this.id.matches("GV\\d{3}"));

        System.out.println("Xin mời nhập tên giàng viên");
        this.name = sc.nextLine();
        System.out.println("Xin mời nhập email");
        this.email = sc.nextLine();
        System.out.println("Xin mời nhập học hàm:");
        for (int i = 0; i < RANKS.length; i ++)
            System.out.println(i + 1 + ": " + RANKS[i]);
        this.rank = sc.nextInt();
        this.salaryMultiplier = SALARY_MULTIPLIERS[rank - 1];

        System.out.println("Xin mời nhập học vị");
        for (int i = 0; i < LEVELS.length; i ++)
            System.out.println(i + 1 + ": " + LEVELS[i]);
        this.level = sc.nextInt();

        System.out.println("Xin mời nhập số điện thoại");
        this.phone = sc.next();
        sc.nextLine();
        System.out.println("Xin mời nhập số giờ giảng dạy trong tháng");
        this.teachingHours = sc.nextInt();
        sc.nextLine();
        System.out.println("Xin mời nhập địa chỉ");
        this.ad = sc.nextLine();

    }

    @Override
    public String toString() {
        return "ID: " + id + '\n' +
                "Tên: " + name + '\n' +
                "Email:" + email + '\n' +
                "Học hàm:" + rank + '\n' +
                "Học vị: " + level + '\n' +
                "Địa chỉ: " + ad + '\n' +
                "Số điện thoại: " + phone + '\n' +
                "Giờ dạy: " + teachingHours;
    }


    public Object getFeature(String feature) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return this.getClass().getMethod("get" + feature).invoke(this);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(int teachingHours) {
        this.teachingHours = teachingHours;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public float getSalaryMultiplier() {
        return salaryMultiplier;
    }

    public float getSalary(){
        return 0f;
    }
    public void setSalaryMultiplier(int salaryMultiplier) {
        this.salaryMultiplier = salaryMultiplier;
    }


}
