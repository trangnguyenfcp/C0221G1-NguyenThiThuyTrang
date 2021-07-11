package com.codegym.model.service.implement;

import com.codegym.model.entity.Division;
import com.codegym.model.repository.IDivisionRepository;
import com.codegym.model.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public Iterable<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
