package com.codegym.model.repository;

import com.codegym.model.entity.ContractDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetailRepository extends PagingAndSortingRepository<ContractDetail, Long> {
}
