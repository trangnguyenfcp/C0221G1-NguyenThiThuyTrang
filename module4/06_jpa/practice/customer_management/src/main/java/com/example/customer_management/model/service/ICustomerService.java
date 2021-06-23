package com.example.customer_management.model.service;

import com.example.customer_management.model.entity.Customer;

import java.util.List;

public interface ICustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void delete(Long id);
}
