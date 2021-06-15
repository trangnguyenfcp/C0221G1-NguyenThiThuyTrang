package model.repository;

import model.bean.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    public static final String INSERT_NEW_EMPLOYEE = "insert into employee\n" +
            "value(?,?,?);";
    public static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee;";
    public static final String SELECT_EMPLOYEE_BY_ID = "select* from employee where employee_id=?;";
    public static final String DELETE_EMPLOYEE = "delete from employee where employee_id = ?;";
    static final String UPDATE_EMPLOYEE_BY_ID = "update employee\n" +
            "set employee_name=?, employee_birthday = ?\n" +
            "where employee_id = ?;";
    public boolean insertEmployee(Employee employee) throws SQLException {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_EMPLOYEE);
        preparedStatement.setInt(1, employee.getEmployeeId());
        preparedStatement.setString(2, employee.getEmployeeName());
        preparedStatement.setString(3, employee.getEmployeeBirthday());
        check = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        connection.close();
        return check;
    }
    public Employee selectEmployee(int id) throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                employee = new Employee(id, employeeName, employeeBirthday);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }
    public List<Employee> selectAllEmployee() throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        List<Employee> employees = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = null;
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");

                employee = new Employee(employeeId, employeeName, employeeBirthday);
                employees.add(employee);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public boolean deleteEmployee(int id) throws SQLException {
        boolean check;
        try (Connection connection = baseRepository.connectDataBase();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);) {
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
        }
        return check;
    }
    public boolean updateEmployee(int id, Employee employee) throws SQLException {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_BY_ID);
        preparedStatement.setString(1, employee.getEmployeeName());
        preparedStatement.setString(2, employee.getEmployeeBirthday());
        preparedStatement.setInt(3, id);
        check = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        connection.close();
        return check;
    }
}
