package com.codegym.model.repository;

import com.codegym.model.entity.RentType;
import com.codegym.model.entity.Service;
import com.codegym.model.entity.ServiceType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mapping.callback.ReactiveEntityCallbacks;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IServiceRepository extends PagingAndSortingRepository<Service, Long> {

}
