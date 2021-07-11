package com.codegym.model.repository;

import com.codegym.model.entity.Contract;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends PagingAndSortingRepository<Contract, Long> {
}
