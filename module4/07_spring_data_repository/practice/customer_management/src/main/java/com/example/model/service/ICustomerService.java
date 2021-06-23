package com.example.model.service;



import com.example.model.entity.Customer;
import com.example.model.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService{

    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    void save(Customer customer);

    void delete(Long id);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
