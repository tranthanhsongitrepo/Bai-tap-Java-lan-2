package com.company;

import java.util.Scanner;

public class Material {
    private String publisher, id;
    private int numberOfCopies;

    public Material(String publisher, String id, int numberOfCopies) {
        this.publisher = publisher;
        this.id = id;
        this.numberOfCopies = numberOfCopies;
    }

    public Material(){
        this.publisher = this.id = null;
        this.numberOfCopies = 0;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Xin mời nhập ID");
        this.id = sc.nextLine();
        System.out.println("Xin mời nhập nhà xuất bản");
        this.publisher = sc.nextLine();
        System.out.println("Xin mời nhập số bản");
        this.numberOfCopies = sc.nextInt();
        sc.nextLine();
    }
    @Override
    public String toString() {
        return "ID: " + this.id + '\n' +
            "Nhà xuất bản: " + this.publisher + '\n' +
                "Số bản: " + this.numberOfCopies;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

}
