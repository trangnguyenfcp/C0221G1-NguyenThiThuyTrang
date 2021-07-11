package com.codegym.model.service.implement;

import com.codegym.model.entity.Username;
import com.codegym.model.repository.IServiceRepository;
import com.codegym.model.repository.IUserRepository;
import com.codegym.model.service.IUsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsernameService implements IUsernameService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Iterable<Username> findAll() {
        return iUserRepository.findAll();
    }
}
