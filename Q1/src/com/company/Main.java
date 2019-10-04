package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        int country = 84, region, number, mode;
        while (true){

            System.out.println("Mời lựa chọn:");
            System.out.println("1: Thêm một số điện thoại mới");
            System.out.println("2: Tìm một số điện thoại theo mã vùng");
            System.out.println("3: Liệt kê tất cả các số điện thoại");
            System.out.println("4: Tính tổng số điện theo theo từng vùng");
            System.out.println("5: Tìm kiếm theo có đuôi là");
            System.out.println("0: Thoát chương trình");

            int o = sc.nextInt();

            switch (o){
                case 1 :
                    System.out.println("1: Số điện thoại trong nước\n" +
                                        "2 : Số điện thoai quốc tế");
                    do {
                        mode = sc.nextInt();
                    } while (mode != 1 && mode != 2);
                    if (mode == 2){
                        System.out.println("Xin mời nhập mã nước");
                        country = sc.nextInt();

                    }
                    do{
                        System.out.println("Xin mời nhập mã vùng");
                        region = sc.nextInt();
                    } while (region < 10 || region > 999);
                    System.out.println("Xin mời nhập số điện thoại");
                    number = sc.nextInt();
                    if (mode == 1)
                        phoneBook.add(new PhoneNumber(region, number));
                    else
                        phoneBook.add(new IntPhoneNumber(country, region, number));
                    break;
                case 2:
                    region = sc.nextInt();
                    System.out.println(phoneBook.getPhoneNumbersByRegion(region));
                    break;
                case 3:
                    System.out.println("Liệt kê các số điện thoại:\n" +
                                        "0: Toàn bộ\n" +
                                        "1: Số điện thoại trong nước\n" +
                                        "2 : Số điện thoai quốc tế");
                    do {
                        mode = sc.nextInt();
                    } while(mode != 0 && mode != 1 && mode != 2);

                    System.out.println(phoneBook.getPhoneNumbersByCountry(mode));
                    break;

                case 4:
                    do {
                        System.out.println("Nhập mã vùng");
                        region = sc.nextInt();
                    } while (region < 10|| region > 999);

                    System.out.println(phoneBook.sumOfPhoneNumbersInRegion(region));

                 break;
                case 5:
                    System.out.println("Mời nhập 3 số cuối điện thoại");
                    int t;
                    do {
                        t = sc.nextInt();
                    } while (t < 100 || t > 999);
                    System.out.println(phoneBook.findNumberByLast3Digits(t));
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }
    }
}
