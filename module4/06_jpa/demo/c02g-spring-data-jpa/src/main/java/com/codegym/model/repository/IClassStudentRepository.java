package com.codegym.model.repository;

import com.codegym.model.entity.ClassStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassStudentRepository extends JpaRepository<ClassStudent, Integer> {
}
