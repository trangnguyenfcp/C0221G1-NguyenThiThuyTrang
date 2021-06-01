package model.service;

import model.bean.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findByAll();
    Student findById(int id);
    boolean update(int id, Student student);
    boolean save(Student student);
    boolean remove(int id);
}
