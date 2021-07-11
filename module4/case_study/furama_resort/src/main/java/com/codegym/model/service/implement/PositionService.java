package com.codegym.model.service.implement;

import com.codegym.model.entity.Position;
import com.codegym.model.repository.IPositionRepository;
import com.codegym.model.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public Iterable<Position> findAll() {
        return iPositionRepository.findAll();
    }
}
