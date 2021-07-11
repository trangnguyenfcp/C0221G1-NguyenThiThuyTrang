package com.codegym.model.service;

import com.codegym.model.entity.Division;
import com.codegym.model.entity.RentType;

public interface IDivisionService {
    Iterable<Division> findAll();
}
