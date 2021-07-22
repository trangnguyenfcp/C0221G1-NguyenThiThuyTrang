package com.codegym.model.service.implement;

import com.codegym.model.entity.Contract;
import com.codegym.model.repository.IContractRepository;
import com.codegym.model.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;
    @Override
    public Iterable<Contract> finAll() {
        return iContractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
iContractRepository.save(contract);
    }

    @Override
    public Page<Contract> findAllByCustomerName(String name, Pageable pageable) {
        return iContractRepository.findAllByCustomerName(name, pageable);
    }
}
