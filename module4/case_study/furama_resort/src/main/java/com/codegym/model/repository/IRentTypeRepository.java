package com.codegym.model.repository;

import com.codegym.model.entity.RentType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentTypeRepository extends PagingAndSortingRepository<RentType, Long> {
}
