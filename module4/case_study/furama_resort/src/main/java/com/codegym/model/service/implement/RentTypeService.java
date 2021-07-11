package com.codegym.model.service.implement;

import com.codegym.model.entity.RentType;
import com.codegym.model.repository.IRentTypeRepository;
import com.codegym.model.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository iRentTypeRepository;
    @Override
    public Iterable<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
