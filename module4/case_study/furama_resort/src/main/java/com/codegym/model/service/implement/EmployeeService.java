package com.codegym.model.service.implement;

import com.codegym.model.entity.Employee;
import com.codegym.model.repository.IEmployeeRepository;
import com.codegym.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findCustomerByEmployeeNameContaining(String name, Pageable pageable) {
        return iEmployeeRepository.findEmployeeByEmployeeNameContaining(name, pageable);
    }

    @Override
    public Employee findById(Long id) {
        return findById(id);
    }

    @Override
    public Iterable<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(int id) {
        iEmployeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return iEmployeeRepository.findAllEmployees();
    }
}
