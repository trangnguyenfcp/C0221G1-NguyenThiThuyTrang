package com.codegym.model.service;

import com.codegym.model.entity.AttachService;
import com.codegym.model.entity.Service;

public interface IAttachServiceService {
    Iterable<AttachService> findAll();
}
