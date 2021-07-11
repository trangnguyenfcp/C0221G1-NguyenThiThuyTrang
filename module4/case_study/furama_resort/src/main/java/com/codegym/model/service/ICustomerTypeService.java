package com.codegym.model.service;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    Iterable<CustomerType> findAll();
    List<Long> findAllCustomersOfCustomerType(Long id);
    CustomerType  findById(Long id);
}
