package com.codegym.model.service;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.RentType;
import com.codegym.model.entity.Service;
import com.codegym.model.entity.ServiceType;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IServiceService {
    Iterable<Service> findAll();
    void save(Service service);
}
