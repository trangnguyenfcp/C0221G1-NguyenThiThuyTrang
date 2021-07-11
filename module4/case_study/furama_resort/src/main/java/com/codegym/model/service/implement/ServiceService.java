package com.codegym.model.service.implement;

import com.codegym.model.entity.RentType;
import com.codegym.model.entity.Service;
import com.codegym.model.entity.ServiceType;
import com.codegym.model.repository.IServiceRepository;
import com.codegym.model.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {
    @Autowired
    private IServiceRepository iServiceRepository;

    @Override
    public void save(Service service) {
        iServiceRepository.save(service);
    }

    @Override
    public Iterable<Service> findAll() {
        return iServiceRepository.findAll();
    }
}
