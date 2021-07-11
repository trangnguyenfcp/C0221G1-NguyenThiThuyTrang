package com.codegym.model.service;

import com.codegym.model.entity.Contract;

public interface IContractService {
    Iterable<Contract> finAll();
    void save(Contract contract);
}
