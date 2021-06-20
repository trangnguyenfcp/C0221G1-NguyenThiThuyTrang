package com.codegym.model.service;

import com.codegym.model.bean.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
