package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Vehicles vehicles;
        VehiclesList vehiclesList = new VehiclesList();
        String[] features = {"brand", "year", "price", "seats", "engine", "horse power", "load"};
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Xin mời lựa chọn");
            System.out.println("1: Nhập các loại phương tiện giao thông");
            System.out.println("2: In ra danh sách phương tiện giao thông");
            System.out.println("3: Tìm kiếm phương tiện giao thông ");
            System.out.println("4: Tìm kiếm phương tiện theo khoảng xác định của từng tiêu chí");
            System.out.println("5: Tìm 1 số trường");
            System.out.println("6: Sắp xếp theo: hãng sản xuất, giá bán, năm…..");
            System.out.println("7: Tính giá trung bình");
            int option = sc.nextInt();

            switch (option){
                case 0:
                    return;
                case 1:

                    do {
                        System.out.println("Chọn loại xe \n" +
                                "1: Xe tải\n" +
                                "2: Xe máy\n" +
                                "3: Ô tô");

                        option = sc.nextInt();
                    }
                    while (option != 1 && option != 2 && option != 3);
                    switch (option){
                        case 1:
                            vehicles = new Truck();
                            break;
                        case 2:
                            vehicles = new Motorbike();
                            break;
                        case 3:
                            vehicles = new Car();
                            break;
                        default:
                            vehicles = null;
                    }

                    vehicles.input();
                    vehiclesList.add(vehicles);
                    break;

                case 2:
                    vehiclesList.printVehicles();
                    break;
                case 3:
                    System.out.println("Xin mời nhập tiêu chí\n" +
                            "1:Hãng sản xuất\n" +
                            "2: Năm sản xuất\n" +
                            "3: Giá\n" +
                            "4: Chỗ ngồi\n" +
                            "5: Kiểu động cơ\n" +
                            "6: Công suất\n" +
                            "7: Tải trọng");
                    option = sc.nextInt();
                    sc.nextLine();
                    String choice = sc.nextLine();
                    System.out.println(vehiclesList.searchVehicles(features[option - 1], choice));
                    break;
                case 4:
                    System.out.println("Xin mời nhập tiêu chí\n" +
                            "1:Hãng sản xuất\n" +
                            "2: Năm sản xuất\n" +
                            "3: Giá\n" +
                            "4: Chỗ ngồi\n" +
                            "5: Kiểu động cơ\n" +
                            "6: Công suất\n" +
                            "7: Tải trọng");
                    option = sc.nextInt();
                    String s = sc.next(), e = sc.next();
                    System.out.println(vehiclesList.searchVehicles(features[option - 1], s, e));
                break;
                case 5:
                    ArrayList<String> fields =  new ArrayList<>();
                    System.out.println("Xin mời nhập tiêu chí\n" +
                            "1:Hãng sản xuất\n" +
                            "2: Năm sản xuất\n" +
                            "3: Giá\n" +
                            "4: Chỗ ngồi\n" +
                            "5: Kiểu động cơ\n" +
                            "6: Công suất\n" +
                            "7: Tải trọng");
                    option = sc.nextInt();
                    String f = sc.next();
                    while(!f.equals("q")){
                        fields.add(f);
                        f = sc.next();
                    }

                    System.out.println(vehiclesList.searchVehiclesByFeatures(features[option - 1], fields));
                    break;
                case 6:
                    System.out.println("Xin mời nhập tiêu chí\n" +
                            "1:Hãng sản xuất\n" +
                            "2: Năm sản xuất\n" +
                            "3: Giá\n" +
                            "4: Chỗ ngồi\n" +
                            "5: Kiểu động cơ\n" +
                            "6: Công suất\n" +
                            "7: Tải trọng");
                    option = sc.nextInt();
                    vehiclesList.sort(features[option - 1]);
                    System.out.println(vehiclesList);
                    break;
                case 7:
                    System.out.println(vehiclesList.averagePrice());
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;

            }

        }
    }
}
