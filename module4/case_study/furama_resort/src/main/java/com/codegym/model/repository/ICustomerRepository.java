package com.codegym.model.repository;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
        @Query(value = "select c from Customer c where c.customerName like %?1%  and c.flag = 1 order by c.customerName ASC ",nativeQuery = false)
        Page<Customer> findCustomerByCustomerNameContaining(String name, Pageable pageable);
        @Query(value = "select c from Customer c where c.customerBirthday like %?1%  and c.flag = 1",nativeQuery = false)
        Page<Customer> findCustomerByCustomerBirthdayContaining(String birthday, Pageable pageable);
        @Query(value = "select c from Customer c where c.customerAddress like %?1%  and c.flag = 1",nativeQuery = false)
        Page<Customer> findCustomerByCustomerAddressContaining(String address, Pageable pageable);
        @Query(value = "select c from Customer c where c.customerName like %?1% and c.customerBirthday like %?2% and c.customerAddress like %?3% and c.flag = 1 order by c.customerName ASC ",nativeQuery = false)
        Page<Customer> findCustomer(String name, String birthday, String address, Pageable pageable);
        @Modifying
        @Transactional
        @Query(value = "update customer set flag = 0 where customer_id = ?1",nativeQuery = true)
        void deleteCustomer(Long id);

        @Query(value = "select * from customer where flag = 1",nativeQuery = true)
        List<Customer> findAllCustomers();
        Optional<Customer> findByCustomerCode(String code);
}
