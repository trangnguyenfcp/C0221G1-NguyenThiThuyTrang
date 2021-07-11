package com.codegym.model.service.implement;

import com.codegym.model.entity.EducationDegree;
import com.codegym.model.repository.IEducationDegreeRepository;
import com.codegym.model.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public Iterable<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
