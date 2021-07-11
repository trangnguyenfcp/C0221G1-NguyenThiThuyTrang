package com.codegym.model.service;

import com.codegym.model.entity.Position;
import com.codegym.model.entity.RentType;

public interface IPositionService {
    Iterable<Position> findAll();
}
