package com.codegym.model.service.implement;

import com.codegym.model.entity.ServiceType;
import com.codegym.model.repository.IServiceRepository;
import com.codegym.model.repository.IServiceTypeRepository;
import com.codegym.model.service.ICustomerTypeService;
import com.codegym.model.service.IServiceService;
import com.codegym.model.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository iServiceTypeRepository;

    @Override
    public Iterable<ServiceType> findAll() {
        return iServiceTypeRepository.findAll();
    }
}
