package com.codegym.model.service.impl;

import com.codegym.model.entity.ClassStudent;
import com.codegym.model.repository.IClassStudentRepository;
import com.codegym.model.service.IClassStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassStudentService implements IClassStudentService {

    @Autowired
    private IClassStudentRepository iClassStudentRepository;

    @Override
    public List<ClassStudent> findAll() {
        return this.iClassStudentRepository.findAll();
    }
}
