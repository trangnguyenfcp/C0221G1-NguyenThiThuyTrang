package com.example.customer_management.model.repository;

import com.example.customer_management.model.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository  extends PagingAndSortingRepository<Customer,Long> {
}
