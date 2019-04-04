package model;

import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentModel {
    private Connection cnn = null;

    private void initConnection() throws SQLException {
        if (cnn == null || cnn.isClosed()){
            ConnectionDb db = new ConnectionDb();
            cnn = db.ConnectionMysql();
        }
    }

    public void insert(Student student){
        try {
            initConnection();
            PreparedStatement stt = cnn.prepareStatement("insert into ManagerStudent(rollNumber, name , age , address , phone , email)"
                    + "value(?,?,?,?,?,?) ");
            stt.setString(1, student.getRollNumber());
            stt.setString(2, student.getName());
            stt.setInt(3, student.getAge());
            stt.setString(4, student.getAddress());
            stt.setInt(5, student.getPhone());
            stt.setString(6, student.getEmail());
            stt.execute();
            System.out.println("Anh ơi lưu được rồi!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Student> findAll() throws SQLException {
        initConnection();
        ArrayList<Student> list = new ArrayList<Student>();
        PreparedStatement statement = cnn.prepareStatement("select * from ManagerStudent");
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.wasNull()){
            while (resultSet.next()){
                Student st = new Student(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3),
                        resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6));

                list.add(st);
            }
        }

        return list;

    }


    public  Student findOne(String id) throws SQLException {
        Student st = null;
        initConnection();
        PreparedStatement preparedStatement = cnn.prepareStatement("select * from ManagerStudent where rollNumber = ?");
        preparedStatement.setString(1, id);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()){
            st = new Student(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6));
         }
        return st;
    }

    public void update(Student student){
        try {
            initConnection();
            PreparedStatement preparedStatement = cnn.prepareStatement("select * from ManagerStudent where rollNumber = ?");
            preparedStatement.setString(1, student.getRollNumber());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                preparedStatement = cnn.prepareStatement("UPDATE ManagerStudent SET rollNumber = ?, name = ?, age = ?, address = ?, phone = ?, email = ? where rollNumber = ?");
                preparedStatement.setString(1, resultSet.getString(1));
                preparedStatement.setString(2, student.getName());
                preparedStatement.setInt(3, student.getAge());
                preparedStatement.setString(4, student.getAddress());
                preparedStatement.setInt(5, student.getPhone());
                preparedStatement.setString(6, student.getEmail());
                preparedStatement.setString(7, student.getRollNumber());
                preparedStatement.execute();
                System.out.println("Đã thay đổi thành công!!!");
            }else{
                System.out.println("ko co thang sv nao ca");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
