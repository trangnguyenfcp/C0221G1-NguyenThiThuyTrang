package model.service.implement;

import model.bean.Employee;
import model.common.Validate;
import model.repository.EmployeeRepository;
import model.service.EmployeeService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImp implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public Map<String, String> insertEmployee(Employee employee) throws SQLException, ParseException {
        Map<String, String> mapMsg = new HashMap<>();
        mapMsg.put("name", Validate.validateName(employee.getEmployeeName()));
        mapMsg.put("birthday", Validate.validateBirthday(employee.getEmployeeBirthday()));
        int count = 0;
        for (String validate : mapMsg.values())
        {
            if (validate.equals("")){
                count++;
            }
        }
        if (count==mapMsg.size()){
            employeeRepository.insertEmployee(employee);
        }
        return mapMsg;
    }

    @Override
    public Employee selectEmployee(int id) throws SQLException {
        return employeeRepository.selectEmployee(id);
    }

    @Override
    public List<Employee> selectAllEmployees() throws SQLException {
        return employeeRepository.selectAllEmployee();
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public Map<String, String> updateEmployee(int id, Employee employee) throws SQLException, ParseException {
        Map<String, String> mapMsg = new HashMap<>();
        mapMsg.put("name", Validate.validateName(employee.getEmployeeName()));
        mapMsg.put("birthday", Validate.validateBirthday(employee.getEmployeeBirthday()));
        int count = 0;
        for (String validate : mapMsg.values())
        {
            if (validate.equals("")){
                count++;
            }
        }
        if (count==mapMsg.size()){
            employeeRepository.updateEmployee(id,employee);
        }
        return mapMsg;
    }
}
