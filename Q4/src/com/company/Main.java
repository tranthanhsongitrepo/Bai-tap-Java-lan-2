package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static final String[] TYPES_OUT = {"Giảng viên cơ hữu", "Giảng viên thỉnh giảng"};
    public static final String[] FEATURES_OUT = {"Email", "Học hàm", "Địa chỉ", "SĐT", "Giờ dạy", "Học bậc", "Hệ số lương", "Tên", "ID", "Lương cơ bản", "Số giờ quy định", "Công ty"};
    private static final String[] FEATURES_IN = {"Email", "Level", "Ad", "Phone", "TeachingHours", "Rank", "SalaryMultiplier", "Name", "Id", "BaseSalary", "WorkHourRequirement", "Company"};

    private static String inputFeature() {
        System.out.println("Xin mời nhập tiêu chí");

        for (int i = 0; i < FEATURES_OUT.length; i ++){
            System.out.println(i + 1 + ": " + FEATURES_OUT[i]);
        }

        return FEATURES_IN[new Scanner(System.in).nextInt() - 1];
    }
    public static final String[] TYPES_IN = {FullTimeProffesor.class.getName(), HiredProfessor.class.getName()};
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ProfessorList professorList = new ProfessorList();
        while (true){
            Professor professor;
            Scanner sc = new Scanner(System.in);
            System.out.println("Xin mời lựa chọn");
            System.out.println("1: Nhập vào thông tin giảng viên");
            System.out.println("2: In ra danh sách toàn bộ giảng viên");
            System.out.println("3: Xóa, sửa giảng viên");
            System.out.println("4: In ra danh sách giảng viên cơ hữu");
            System.out.println("5: In ra danh sách giảng viên thỉnh giảng");
            System.out.println("6: Tìm kiếm giảng viên gần đúng");
            System.out.println("7: Sắp xếp danh sách theo họ tên, hệ số lương, theo lương lĩnh");
            System.out.println("8: Tính tổng số tiền lương của toàn bộ giảng viên, trung bình lương");
            System.out.println("9: Tìm giảng viên có tổng lương cao nhất");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 0:
                    return;
                case 1:
                    System.out.println("Xin mời chọn loại:");

                    for (int i = 0; i <  TYPES_OUT.length; i ++)
                        System.out.println(i + 1 + ": " + TYPES_OUT[i]);
                    option = sc.nextInt();

                    Class<?> c = Class.forName(TYPES_IN[option - 1]);
                    Constructor<?> ctor = c.getConstructor();
                    professor = (Professor) ctor.newInstance();
                    professor.input();
                    professorList.add(professor);
                    break;
                case 2:
                    professorList.printProfessors(Professor.class.getName());
                    break;
                case 3:
                    System.out.println("Xin chọn");
                    System.out.println("1: Xóa");
                    System.out.println("2: Sửa");
                    option = sc.nextInt();
                    sc.nextLine();
                    String t;
                    do {
                        System.out.println("Xin mời nhập mã ID cần chỉnh sửa/xóa");
                        t = sc.nextLine().trim().toUpperCase();
                    } while (!t.matches("GV\\d{3}"));
                    switch (option){
                        case 1:
                            professorList.remove(t);
                            break;
                        case 2:
                            System.out.println("Xin mời nhập thông tin giảng viên mới");
                            professor = new Professor();
                            professor.input();
                            professorList.replace(t, professor);
                            break;
                    }
                    break;
                case 4:
                    professorList.printProfessors(FullTimeProffesor.class.getName());
                    break;
                case 5:
                    professorList.printProfessors(HiredProfessor.class.getName());
                    break;
                case 6:
                    String feature = inputFeature();
                    System.out.println("Xin mời nhập giá trị");
                    professorList.getProfessorsWith(feature, sc.nextLine()).printProfessors(Professor.class.getName());
                    break;
                case 7:
                    System.out.println("Xin mời nhập tiêu chí");
                    professorList.sortBy(inputFeature());
                    break;
                case 8:
                    System.out.println(professorList.totalSalary() + professorList.getAvarage());
                    break;
                case 9:
                    System.out.println(professorList.higestSalary());
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;


            }
        }
    }
}
