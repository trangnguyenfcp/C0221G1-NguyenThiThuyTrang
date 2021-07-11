package com.codegym.model.repository;

import com.codegym.model.entity.ServiceType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceTypeRepository extends PagingAndSortingRepository<ServiceType, Long> {
}
