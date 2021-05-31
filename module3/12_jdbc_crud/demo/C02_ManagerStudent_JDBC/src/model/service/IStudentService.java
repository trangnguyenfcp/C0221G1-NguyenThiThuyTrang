package model.service;

import model.bean.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findByAll();
    Student findById(int id);
    boolean update(int id, Student student);
    boolean add(Student student);
    boolean remove(int id);
}
