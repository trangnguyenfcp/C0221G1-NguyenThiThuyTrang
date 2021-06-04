package model.service;

import model.bean.Customer;
import model.bean.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    public void insertEmployee(Employee employee) throws SQLException;
    public Employee selectEmployee(int id) throws SQLException;
    public List<Employee> findByName(String keyword) throws SQLException;
    public List<Employee> selectAllEmployees() throws SQLException;
    public boolean deleteEmployee(int id) throws SQLException;
    public boolean updateEmployee(int id, Employee employee) throws SQLException;
}
