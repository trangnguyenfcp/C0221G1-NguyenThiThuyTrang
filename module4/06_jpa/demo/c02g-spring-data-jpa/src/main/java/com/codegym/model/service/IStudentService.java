package com.codegym.model.service;

import com.codegym.model.entity.Student;

import java.util.List;

public interface IStudentService {
    void save(Student student);
    List<Student> findAll();
    Student findById(Integer id);
}
