package com.codegym.model.service.implement;

import com.codegym.model.entity.AttachService;
import com.codegym.model.repository.IAttachServiceRepository;
import com.codegym.model.service.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachServiceService implements IAttachServiceService {
    @Autowired
    private IAttachServiceRepository iAttachServiceRepository;

    @Override
    public Iterable<AttachService> findAll() {
        return iAttachServiceRepository.findAll();
    }
}
