package controller;

import entity.Student;
import model.StudentModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentController implements ApplicationController {
    private ArrayList<Student> list = new ArrayList<Student>();
    private Scanner scanner = new Scanner(System.in);
    private StudentModel model = new StudentModel();
    public void create() {

        System.out.println("Nhập mã sinh viên:");
        String rollNumber = scanner.nextLine();
        System.out.println("Nhập tên sinh viên:");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi sinh viên:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập địa chỉ sinh viên:");
        String address = scanner.nextLine();
        System.out.println("Nhập số điện thoại:");
        int phone = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập email sinh viên:");
        String email = scanner.nextLine();
        Student student = new Student(rollNumber, name, age, address, phone, email);
        model.insert(student);
    }

    public void readList() {

        try {
            ArrayList<Student> list =  model.findAll();
            System.out.printf("%15s | %15s | %15s | %15s\n", "Mã sinh viên", "Tên", "Tuổi", "Địa chỉ");
            for (int i = 0; i < list.size(); i++) {
                Student student = list.get(i);
                System.out.printf("%15s | %15s | %15s | %15s\n",
                        student.getRollNumber(), student.getName(), student.getAge(), student.getAddress());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void update() {
        System.out.println("Nhập mã sinh viên bạn muốn thay đổi:");
        String rollNumber = scanner.nextLine();

        Student st = null;
        try {
            st = model.findOne(rollNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (st != null){
            System.out.println("Nhập tên sinh viên cần thay đổi:");
            String name = scanner.nextLine();
            System.out.println("Nhập tuổi sinh viên cần thay đổi:");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhập địa chỉ:");
            String address = scanner.nextLine();
            System.out.println("Nhập số điện thoại:");
            int phone = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhập email:");
            String email = scanner.nextLine();
            Student student = new Student(st.getRollNumber(), name, age, address, phone, email);
            model.update(student);
        }
    }

    public void delete() {

    }

    public void find() {

    }
}
