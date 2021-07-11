package com.codegym.model.service;

import com.codegym.model.entity.CustomerType;
import com.codegym.model.entity.ServiceType;

public interface IServiceTypeService {
    Iterable<ServiceType> findAll();
}
