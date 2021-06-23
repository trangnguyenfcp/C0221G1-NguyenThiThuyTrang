package com.example.customer_management.model.service.implement;

import com.example.customer_management.model.entity.Customer;
import com.example.customer_management.model.repository.ICustomerRepository;
import com.example.customer_management.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
            iCustomerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        iCustomerRepository.deleteById(id);

    }
}
