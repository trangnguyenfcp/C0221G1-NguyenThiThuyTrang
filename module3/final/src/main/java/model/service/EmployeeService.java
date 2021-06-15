package model.service;

import model.bean.Employee;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public Map<String, String> insertEmployee(Employee employee) throws SQLException, ParseException;
    public Employee selectEmployee(int id) throws SQLException;
    public List<Employee> selectAllEmployees() throws SQLException;
    public boolean deleteEmployee(int id) throws SQLException;
    public Map<String, String> updateEmployee(int id, Employee employee) throws SQLException, ParseException;

}
