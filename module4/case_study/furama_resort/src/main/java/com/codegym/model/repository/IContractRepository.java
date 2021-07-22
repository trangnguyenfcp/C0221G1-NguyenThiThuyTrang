package com.codegym.model.repository;

import com.codegym.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IContractRepository extends PagingAndSortingRepository<Contract, Long> {

    @Query(value = "select * from contract con " +
            "join customer c on con.customer_id = c.customer_id " +
            "join contract_detail cd on con.contract_id = cd.contract_id " +
            "join attach_service att on att.attach_service_id = cd.attach_service_id " +
            "where con.flag = 1 and c.customer_name like %?1% " +
            "group by con.contract_id " +
            "having curdate() between con.contract_start_date and con.contract_end_date", nativeQuery = true)
    Page<Contract> findAllByCustomerName(String name, Pageable pageable);
}
