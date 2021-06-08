package model.repository;

import model.bean.Customer;
import model.bean.CustomerUsingService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUsingServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    public static final String SELECT_ALL_CUSTOMERS_USING_SERVICE = "SELECT * FROM customer_using_service;";
    public List<CustomerUsingService> selectAllCustomer() throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        List<CustomerUsingService> customers = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS_USING_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            CustomerUsingService customerUsingService = null;
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String customerName = resultSet.getString("customer_name");
                String customerPhone = resultSet.getString("customer_phone");
                int contractId = resultSet.getInt("contract_id");
                String contractStartDate = resultSet.getString("contract_start_date");
                String contractEndDate = resultSet.getString("contract_end_date");
                String attachServiceName = resultSet.getString("attach_service_name");
                int attachServiceUnit = resultSet.getInt("attach_service_unit");

                customerUsingService = new CustomerUsingService(customerId, customerName, customerPhone, contractId, contractStartDate, contractEndDate, customerPhone, attachServiceName, attachServiceUnit);
                customers.add(customerUsingService);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
