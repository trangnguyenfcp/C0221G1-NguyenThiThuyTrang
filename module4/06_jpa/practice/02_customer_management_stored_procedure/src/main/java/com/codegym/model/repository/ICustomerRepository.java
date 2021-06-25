package com.codegym.model.repository;

import com.codegym.model.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long>{
//    @Query(value = "CALL Insert_Customer(:firstName, :lastName)", nativeQuery = true)
    @Procedure(procedureName = "Insert_Customer")
    void insertCallCustomer(String fist_name, String last_name);}
