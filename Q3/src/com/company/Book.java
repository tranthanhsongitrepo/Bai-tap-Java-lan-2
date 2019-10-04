package com.company;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Book extends Material{
    private String name, author;
    private int pageCount;

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Tên sách: " + this.getName() + '\n' +
                "Tên tác giả: " + this.getAuthor() + '\n' +
                "Số trang: " + this.getPageCount();
    }
    public Book(){
        this.name = this.author = null;
        this.pageCount = 0;
    }

    @Override
    public void input(){
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.println("Xin mời nhập tên");
        this.name = sc.nextLine();
        System.out.println("Xin mời nhập tác giả");
        this.author = sc.nextLine();
        System.out.println("Xin mời nhập số trang");
        this.pageCount = sc.nextInt();
        sc.nextLine();
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public Book(String id, String publisher, int numberOfCopies, String name, String author, int pageCount) {
        super(publisher, id, numberOfCopies);
        this.name = name;
        this.author = author;
        this.pageCount = pageCount;
    }
}
