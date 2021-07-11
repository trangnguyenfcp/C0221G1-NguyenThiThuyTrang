package com.codegym.model.service.implement;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.CustomerType;
import com.codegym.model.repository.ICustomerTypeRepository;
import com.codegym.model.service.ICustomerService;
import com.codegym.model.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public Iterable<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public List<Long> findAllCustomersOfCustomerType(Long id) {
        return iCustomerTypeRepository.findAllCustomersOfCustomerType(id);
    }

    @Override
    public CustomerType findById(Long id) {
        return iCustomerTypeRepository.findById(id).orElse(null);
    }
}
