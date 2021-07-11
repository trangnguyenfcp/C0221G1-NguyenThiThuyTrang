package com.codegym.model.service;

import com.codegym.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Iterable<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findCustomerByCustomerNameContaining(String name, Pageable pageable);
    void save(Customer customer);
    Customer  findById(Long id);
}
