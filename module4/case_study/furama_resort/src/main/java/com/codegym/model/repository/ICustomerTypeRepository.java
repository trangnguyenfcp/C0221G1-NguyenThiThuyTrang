package com.codegym.model.repository;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.CustomerType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerTypeRepository extends PagingAndSortingRepository<CustomerType, Long> {
    @Query(value = "select C.customer_id from customer C \n" +
            "join customer_type CT on C.customer_type_id = CT.customer_type_id\n" +
            "where CT.customer_type_id = ?;", nativeQuery = true)
    List<Long> findAllCustomersOfCustomerType(Long id);
}
