package com.codegym.model.service.implement;

import com.codegym.model.entity.Customer;
import com.codegym.model.repository.ICustomerRepository;
import com.codegym.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public void insertWithStoredProcedure(Customer customer) {

       iCustomerRepository.insertCallCustomer(customer.getFirstName(), customer.getLastName());
    }
}
