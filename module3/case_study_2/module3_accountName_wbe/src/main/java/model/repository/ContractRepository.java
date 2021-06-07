package model.repository;

import model.bean.Contract;
import model.bean.Customer;
import model.bean.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractRepository {
    BaseRepository baseRepository = new BaseRepository();
    public static final String INSERT_NEW_CONTRACT = "insert into contract\n" +
            "value(?,?,?,?,?,?,?);";
    public static final String SELECT_ALL_CONTRACTS = "select* from contract;";
    public static final String SELECT_ALL_EMPLOYEE_ID = "select employee_id, employee_name from employee;";
    public static final String SELECT_ALL_CUSTOMER_ID = "select customer_id, customer_name from customer;";
    public static final String SELECT_ALL_SERVICE_ID = "select service_id, service_name from service;";

    public void insertService(Contract contract) throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_CONTRACT);

        preparedStatement.setInt(1, contract.getContractId());
        preparedStatement.setInt(2, contract.getEmployeeId());
        preparedStatement.setInt(3, contract.getCustomerId());
        preparedStatement.setInt(4, contract.getServiceId());
        preparedStatement.setString(5, contract.getContractStartDate());
        preparedStatement.setString(6, contract.getContractEndDate());
        preparedStatement.setInt(7, contract.getContractId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public Map<Integer, String> selectAllEmployeeId() throws SQLException {
        Map<Integer, String> employees = new HashMap<>();
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            Contract contract = null;
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                employees.put(employeeId, employeeName);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public Map<Integer, String> selectAllCustomerId() throws SQLException {
        Map<Integer, String> customers = new HashMap<>();
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String customerName = resultSet.getString("customer_name");
                customers.put(customerId, customerName);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Map<Integer, String> selectAllServiceId() throws SQLException {
        Map<Integer, String> services = new HashMap<>();
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int serviceId = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                services.put(serviceId, serviceName);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }
    public List<Contract> selectAllContracts() throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        List<Contract> contracts = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            Contract contract = null;
            while (resultSet.next()) {
                int contractId = resultSet.getInt("contract_id");
                int employeeId = resultSet.getInt("employee_id");
                int customerId = resultSet.getInt("customer_id");
                int serviceId = resultSet.getInt("service_id");
                String contractStartDate = resultSet.getString("contract_start_date");
                String contractEndDate = resultSet.getString("contract_end_date");
                int contractDeposit = resultSet.getInt("contract_deposit");
                contract = new Contract(contractId, employeeId, customerId, serviceId, contractStartDate, contractEndDate, contractDeposit);
                contracts.add(contract);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;
    }
}
