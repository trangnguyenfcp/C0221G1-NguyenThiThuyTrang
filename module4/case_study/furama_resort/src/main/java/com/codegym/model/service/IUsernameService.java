package com.codegym.model.service;

import com.codegym.model.entity.RentType;
import com.codegym.model.entity.Username;

public interface IUsernameService {
    Iterable<Username> findAll();
}
