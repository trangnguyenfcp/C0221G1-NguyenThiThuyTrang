package com.codegym.model.service.implement;

import com.codegym.model.entity.ContractDetail;
import com.codegym.model.repository.IContractDetailRepository;
import com.codegym.model.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public Iterable<ContractDetail> findAll() {
        return iContractDetailRepository.findAll();
    }
}
