package com.codegym.model.service.implement;

import com.codegym.model.entity.Customer;
import com.codegym.model.repository.ICustomerRepository;
import com.codegym.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findCustomerByCustomerNameContaining(String name, Pageable pageable) {
        return iCustomerRepository.findCustomerByCustomerNameContaining(name, pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
     return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Customer> findAll() {
        return iCustomerRepository.findAll();
    }
}
