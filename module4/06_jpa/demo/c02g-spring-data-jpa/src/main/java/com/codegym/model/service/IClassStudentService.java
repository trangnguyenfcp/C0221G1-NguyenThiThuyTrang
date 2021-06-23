package com.codegym.model.service;

import com.codegym.model.entity.ClassStudent;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IClassStudentService {
    List<ClassStudent> findAll();
}
