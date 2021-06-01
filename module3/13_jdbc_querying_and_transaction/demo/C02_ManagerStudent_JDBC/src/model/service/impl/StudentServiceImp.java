package model.service.impl;

import model.bean.Student;
import model.repository.StudentRepository;
import model.service.IStudentService;

import java.util.List;

public class StudentServiceImp implements IStudentService {
    StudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findByAll() {
        return studentRepository.findByAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public boolean update(int id, Student student) {
        return studentRepository.update(id,student);
    }

    @Override
    public boolean save(Student student) {
       return studentRepository.save(student);
    }

    @Override
    public boolean remove(int id) {
     return false;
    }
}
