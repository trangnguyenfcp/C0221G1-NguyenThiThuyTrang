package com.codegym.model.service;

import com.codegym.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findCustomerByCustomerNameContaining(String name, Pageable pageable);
    void save(Customer customer);
    Customer  findById(Long id);
    void deleteCustomer(Long id);
    List<Customer> findAllCustomers();
    Customer findByCustomerCode(String code);
    Page<Customer> findCustomerByCustomerBirthdayContaining(String birthday, Pageable pageable);
    Page<Customer> findCustomerByCustomerAddressContaining(String address, Pageable pageable);
    Page<Customer> findCustomer(String name, String birthday, String address, Pageable pageable);


}
