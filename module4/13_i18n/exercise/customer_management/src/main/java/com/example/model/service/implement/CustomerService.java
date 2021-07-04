package com.example.model.service.implement;


import com.example.model.entity.Customer;
import com.example.model.repository.ICustomerRepository;
import com.example.model.service.ICustomerService;
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
    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return iCustomerRepository.findAllByFirstNameContaining(firstname, pageable);
    }
}
