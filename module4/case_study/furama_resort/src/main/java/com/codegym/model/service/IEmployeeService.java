package com.codegym.model.service;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Employee;
import com.codegym.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Iterable<Employee> findAll();
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findCustomerByEmployeeNameContaining(String name, Pageable pageable);
    void save(Employee employee);
    Employee  findById(Long id);
}
