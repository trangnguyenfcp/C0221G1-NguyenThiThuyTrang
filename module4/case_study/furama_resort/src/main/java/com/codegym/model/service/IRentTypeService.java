package com.codegym.model.service;

import com.codegym.model.entity.RentType;
import com.codegym.model.entity.ServiceType;

public interface IRentTypeService {
    Iterable<RentType> findAll();
}
