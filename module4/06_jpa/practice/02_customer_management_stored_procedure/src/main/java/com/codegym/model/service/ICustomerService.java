package com.codegym.model.service;

import com.codegym.model.entity.Customer;

public interface ICustomerService {
    public void insertWithStoredProcedure(Customer customer);
}
