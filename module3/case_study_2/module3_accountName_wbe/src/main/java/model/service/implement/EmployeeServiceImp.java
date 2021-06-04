package model.service.implement;

import model.bean.Customer;
import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.service.EmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImp implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public void insertEmployee(Employee employee) throws SQLException {
     employeeRepository.insertEmployee(employee);
    }

    @Override
    public Employee selectEmployee(int id) throws SQLException {
        return employeeRepository.selectEmployee(id);
    }

    @Override
    public List<Employee> findByName(String keyword) throws SQLException {
        return employeeRepository.findByName(keyword);
    }

    @Override
    public List<Employee> selectAllEmployees() throws SQLException {
        return employeeRepository.selectAllEmployees();
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(int id, Employee employee) throws SQLException {
        return employeeRepository.updateEmployee(id, employee);
    }
}
