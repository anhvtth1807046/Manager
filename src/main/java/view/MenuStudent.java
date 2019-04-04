package view;

import controller.ApplicationController;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuStudent implements Imenu {
    public void menu(ApplicationController controller) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("*********Trang quản lý sinh viên*********");
            System.out.println("1.Thêm mới sinh viên");
            System.out.println("2.Hiển thị danh sách sinh viên ");
            System.out.println("3.Sửa sinh viên");
            System.out.println("4.Xoá sinh viên");
            System.out.println("5.Tìm kiếm sinh viên");
            System.out.println("6.Quay lại");
            System.out.println("-------------------------------------------");
            System.out.println("Vui lòng lựa chọn từ 1 đến 5.");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    controller.create();
                    break;
                case 2:
                    controller.readList();
                    break;
                case 3:
                    try {
                        controller.update();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    controller.delete();
                    break;
                case 5:
                    controller.find();
                    break;
                default:
                    System.out.println("Hẹn gặp lại bạn sau!!!");
                    break;
            }
            if (choice == 6){
                break;
            }
        }


    }

}
