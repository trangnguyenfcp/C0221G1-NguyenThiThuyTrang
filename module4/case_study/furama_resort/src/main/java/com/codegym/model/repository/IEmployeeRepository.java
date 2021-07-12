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

@Repository
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    @Query(value = "select e from Employee e where e.employeeName like %?1%  and e.flag = 1 order by e.employeeName ASC ",nativeQuery = false)
    Page<Employee> findEmployeeByEmployeeNameContaining(String name, Pageable pageable);
    @Modifying
    @Transactional
    @Query(value = "update employee set flag = 0 where employee_id = ?1",nativeQuery = true)
    void deleteEmployee(int id);

    @Query(value = "select * from employee where flag = 1",nativeQuery = true)
    List<Employee> findAllEmployees();
}
