package model.repository;

import model.bean.Customer;
import model.bean.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    public static final String INSERT_NEW_EMPLOYEE = "insert into employee\n" +
            "value(?,?,?,?,?,?,?,?,?,?,?,?);";
    public static final String SELECT_ALL_EMPLOYEES = "select* from employee;";
    public static final String SELECT_EMPLOYEE_BY_ID = "select* from employee where employee_id=?;";
    public static final String DELETE_EMPLOYEE = "delete from employee where employee_id = ?;";
    public static final String UPDATE_EMPLOYEE_BY_ID = "update employee\n" +
            "set employee_name=?, position_id = ?,education_degree_id = ?,division_id = ?,username = ?,employee_birthday = ?,employee_id_card,employee_salary = ?, employee_phone = ?, employee_email = ?,employee_address = ?,\n" +
            "where customer_id = ?;";
    public static final String FIND_BY_NAME = "select* from employee\n" +
            "where employeer_name like ?;";


    public void insertEmployee(Employee employee) throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_EMPLOYEE);
        preparedStatement.setInt(1, employee.getEmployeeId());
        preparedStatement.setString(2, employee.getEmployeeName());
        preparedStatement.setInt(3, employee.getPositionId());
        preparedStatement.setInt(4, employee.getEducationDegreeId());
        preparedStatement.setInt(5, employee.getDivisionId());
        preparedStatement.setString(6, employee.getUsername());
        preparedStatement.setString(7, employee.getEmployeeBirthday());
        preparedStatement.setString(8, employee.getEmployeeIdCard());
        preparedStatement.setString(9, employee.getEmployeeSalary());
        preparedStatement.setString(10, employee.getEmployeePhone());
        preparedStatement.setString(11, employee.getEmployeeEmail());
        preparedStatement.setString(12, employee.getEmployeeAddress());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();

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
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                String employeeSalary = resultSet.getString("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                employee = new Employee(id, employeeName, positionId, educationDegreeId, divisionId, username, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }


    public List<Employee> findByName(String keyword) throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                String employeeSalary = resultSet.getString("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                employee = new Employee(employeeId, employeeName, positionId, educationDegreeId, divisionId, username, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress);
                employees.add(employee);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }


    public List<Employee> selectAllEmployees() throws SQLException {
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
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                String employeeSalary = resultSet.getString("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                employee = new Employee(employeeId, employeeName, positionId, educationDegreeId, divisionId, username, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress);
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
        preparedStatement.setInt(2, employee.getPositionId());
        preparedStatement.setInt(3, employee.getEducationDegreeId());
        preparedStatement.setInt(4, employee.getDivisionId());
        preparedStatement.setString(5, employee.getUsername());
        preparedStatement.setString(6, employee.getEmployeeBirthday());
        preparedStatement.setString(7, employee.getEmployeeIdCard());
        preparedStatement.setString(8, employee.getEmployeeSalary());
        preparedStatement.setString(9, employee.getEmployeePhone());
        preparedStatement.setString(10, employee.getEmployeeEmail());
        preparedStatement.setString(11, employee.getEmployeeAddress());
        check = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        connection.close();
        return check;
    }

    public Customer getUserById(int id) throws SQLException {
        return null;
    }
}
