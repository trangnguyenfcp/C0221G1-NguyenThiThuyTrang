package com.codegym.model.service;

import com.codegym.model.entity.AttachService;
import com.codegym.model.entity.ContractDetail;

public interface IContractDetailService {
    Iterable<ContractDetail> findAll();
}
