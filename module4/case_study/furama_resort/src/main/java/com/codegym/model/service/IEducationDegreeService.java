package com.codegym.model.service;

import com.codegym.model.entity.EducationDegree;
import com.codegym.model.entity.RentType;

public interface IEducationDegreeService {
    Iterable<EducationDegree> findAll();
}
