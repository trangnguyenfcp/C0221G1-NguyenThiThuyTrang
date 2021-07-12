package com.codegym.model.service.implement;

import com.codegym.model.entity.Customer;
import com.codegym.model.repository.ICustomerRepository;
import com.codegym.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void deleteCustomer(Long id) {
        iCustomerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return iCustomerRepository.findAllCustomers();
    }

    @Override
    public Customer findByCustomerCode(String code) {
       return iCustomerRepository.findByCustomerCode(code).orElse(null);
    }

    @Override
    public Page<Customer> findCustomerByCustomerBirthdayContaining(String birthday, Pageable pageable) {
        return iCustomerRepository.findCustomerByCustomerBirthdayContaining(birthday, pageable);
    }

    @Override
    public Page<Customer> findCustomerByCustomerAddressContaining(String address, Pageable pageable) {
        return iCustomerRepository.findCustomerByCustomerAddressContaining(address, pageable);
    }

    @Override
    public Page<Customer> findCustomer(String name, String birthday, String address, Pageable pageable) {
        return iCustomerRepository.findCustomer(name, birthday, address, pageable);
    }
}
