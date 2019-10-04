package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final String[] TYPES_OUT = {"Sách", "Báo", "Tạp chí"};
    private static final String[] TYPES_IN = {"Book", "Newspaper", "Magazine"} ;
    private static final String[] FEATURES_OUT = {"Id", "Nhà xuất bản", "Số bản phát hành", "Tên tác giả", "Tên sách", "Số trang", "Số phát hành", "Tháng phát hành", "Ngày phát hành"};
    private static final String[] FEATURE_IN = {"Id", "Publisher", "NumberOfCopies", "Author", "Name", "PageCount", "PublishedNumber", "PublishedMonth", "PublishedDate"};
    public static String chooseFeature(Scanner sc){
        System.out.println("Xin  mời nhập tiêu chí");
        for (int i = 0; i < FEATURES_OUT.length; i ++)
            System.out.println(i + 1 + ": " + FEATURES_OUT[i]);
        return FEATURE_IN[sc.nextInt() - 1];
    }
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, InstantiationException{

        MaterialList list = new MaterialList();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Xin mời lựa chọn");
            System.out.println("1: Nhập thông tin về các tài liệu");
            System.out.println("2: In ra các tài liệu");
            System.out.println("3: Tìm kiếm tài liệu");
            System.out.println("4: Xóa, sửa tài liệu");
            System.out.println("5: Tìm một số trường");
            System.out.println("6: Sắp xếp");
            System.out.println("7: Tính");

            int option = sc.nextInt();

            switch (option){
                case 1:
                    System.out.println("Xin mời nhập loại tài liệu");
                    for (int i = 0; i < TYPES_OUT.length; i ++){
                        System.out.println(i + 1 + ": " + TYPES_OUT[i]);
                    }
                    option = sc.nextInt();

                    Class<?> c = Class.forName("com.company." + TYPES_IN[option - 1]);
                    Constructor<?> ctor = c.getConstructor();
                    Material m = (Material) ctor.newInstance();
                    m.input();
                    list.add(m);
                    break;
                case 2:
                    System.out.println(list.toString());
                    break;
                case 3:
                    String feature = chooseFeature(sc);
                    System.out.println("Xin mời chọn chế độ:");
                    System.out.println("1: Theo riêng từng tiêu chí");
                    System.out.println("2: Theo khoảng xác định của từng tiêu chí");
                    option = sc.nextInt();
                    sc.nextLine();
                    if (option == 1) {
                        System.out.println("Xin mời nhập giá trị tiêu chí");
                        System.out.println(list.getMaterialsWith(feature, sc.nextLine()));
                    }
                    else {
                        System.out.println("Xin mời nhập khoảng");
                        int from = sc.nextInt();
                        int to = sc.nextInt();
                        if (from > to){
                            int temp = from;
                            from = to;
                            to = temp;
                        }
                        System.out.println(list.getMaterialsWith(feature, from, to));
                    }
                    break;
                case 4:
                    System.out.println("Xin mời chọn chế độ");
                    System.out.println("1: Sửa");
                    System.out.println("2: Xóa");
                    option = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Xin mời nhập ID để sửa");
                    String id = sc.nextLine();
                    int index = list.getIndexOf(id);
                    if (option == 1){
                        System.out.println("Xin mời nhập loại tài liệu");
                        for (int i = 0; i < TYPES_OUT.length; i ++){
                            System.out.println(i + 1 + ": " + TYPES_OUT[i]);
                        }
                        option = sc.nextInt();
                        sc.nextLine();

                        Class<?> c2 = Class.forName("com.company." + TYPES_IN[option - 1]);
                        Constructor<?> ctor2 = c2.getConstructor();
                        Material m2 = (Material) ctor2.newInstance();
                        m2.input();
                        list.replace(index, m2);
                    }
                    else{
                        list.remove(index);
                    }
                    break;
                case 5:
                    String f = chooseFeature(sc);
                    sc.nextLine();
                    ArrayList<String> values = new ArrayList<>();
                    String val = "";
                    do {
                        System.out.println("Xin mời nhập trường:");
                        val = sc.nextLine();
                        if (!val.equals("q"))
                        values.add(val);

                    }  while (!val.equals("q"));

                    System.out.println(list.getMaterialsWith(f, Arrays.asList(values.toArray()).toArray(new String[0])));
                    break;
                case 6:
                    list.sortByFeature(chooseFeature(sc));
                    System.out.println(list);
                    break;
                case 7:
                    int s = 0;
                    int[] sums = list.getTotalPublishedNumberOf(TYPES_IN);
                    for (int i : sums)
                        s += i;

                    System.out.println(s);

                    System.out.println(Arrays.toString(sums));

                    System.out.println(list.getMaterialsWith(chooseFeature(sc), sc.nextLine()));
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }



        }
    }
}
