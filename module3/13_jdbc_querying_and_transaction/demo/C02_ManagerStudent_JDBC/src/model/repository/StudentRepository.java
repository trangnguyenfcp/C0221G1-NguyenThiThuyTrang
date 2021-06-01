package model.repository;

import model.bean.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    BaseRopository baseRopository = new BaseRopository();
    final String SELECT_ALL_STUDENT ="select* from student;";
    final String SELECT_STUDENT_BY_ID="select* from student\n" +
            "where id=?;";
    final String UPDATE_STUDENT_BY_ID ="update student \n" +
            "set name =?, age=?,email=?" +
            "where id =?;";
    final String CALL_SP_ADD ="call add_student(?,?,?);";
    public List<Student> findByAll() {
        // kết nối databe=> lấy lại cái danh sách
       Connection connection =baseRopository.connectDataBase();
       List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);
           ResultSet resultSet= preparedStatement.executeQuery();// dùng cho câu lệnh select;
            while (resultSet.next()){ // duyệt trên từng hàng của bảng
                int id =resultSet.getInt("id");
                String name =resultSet.getString("name");
                int age =resultSet.getInt("age");
                String email =resultSet.getString("email");
                Student  student = new Student(id,name,age,email);
                studentList.add(student);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    public Student findById(int id) {
        Connection connection =baseRopository.connectDataBase();
        Student student =null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id1 =resultSet.getInt("id");
                String name =resultSet.getString("name");
                int age =resultSet.getInt("age");
                String email =resultSet.getString("email");
                student = new Student(id1,name,age,email);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public boolean update(int id, Student student) {
        Connection connection =baseRopository.connectDataBase();
        boolean check=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_BY_ID);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setString(3,student.getEmail());
            preparedStatement.setInt(4,id);
            check =preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean save(Student student) {
        Connection connection =baseRopository.connectDataBase();
        CallableStatement callableStatement=null;
        try {
            callableStatement = connection.prepareCall(CALL_SP_ADD);
            callableStatement.setString(1,student.getName());
            callableStatement.setInt(2,student.getAge());
            callableStatement.setString(3,student.getEmail());
            boolean isSuccess  =callableStatement.executeUpdate()>0;
            callableStatement.close();
            connection.close();
            return isSuccess;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        }
        return false;
    }

    public boolean remove(int id) {
        return false;
    }

    public static void main(String[] args) {
//        StudentRepository studentRepository = new StudentRepository();
//        Student student = new Student("hai17",30,"hai@gmail.com");
//        studentRepository.save(student);
//        System.out.println(studentRepository.findByAll().size());
    }
}
