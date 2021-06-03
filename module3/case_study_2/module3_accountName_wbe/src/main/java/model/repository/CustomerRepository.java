package model.repository;

import model.bean.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    BaseRepository baseRepository = new BaseRepository();
    public static final String INSERT_NEW_CUSTOMER = "insert into customer\n" +
            "value(?,?,?,?,?,?,?,?,?);";
    public static final String SELECT_ALL_CUSTOMERS = "select* from customer;";
    public static final String SELECT_CUSTOMER_BY_ID = "select* from customer where customer_id=?;";
    public static final String DELETE_CUSTOMER = "delete from customer where customer_id = ?;";
    public static final String UPDATE_CUSTOMER_BY_ID = "update customer\n" +
            "set `customer_type_id`=?, customer_name=?, customer_birthday = ?,customer_gender = ?,customer_id_card = ?,customer_phone = ?,customer_email = ?,customer_address = ?\n" +
            "where customer_id = ?;";


    public void insertCustomer(Customer customer) throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_CUSTOMER);
        preparedStatement.setInt(1, customer.getCustomer_id());
        preparedStatement.setInt(2, customer.getCustomer_type_id());
        preparedStatement.setString(3, customer.getCustomer_name());
        preparedStatement.setString(4, customer.getCustomer_birthday());
        preparedStatement.setInt(5, customer.getCustomer_gender());
        preparedStatement.setString(6, customer.getCustomer_id_card());
        preparedStatement.setString(7, customer.getCustomer_phone());
        preparedStatement.setString(8, customer.getCustomer_email());
        preparedStatement.setString(9, customer.getCustomer_address());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();

    }

    public Customer selectCustomer(int id) throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("Customer_email");
                String customer_address = resultSet.getString("customer_address");
                customer = new Customer(id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }


    public List<Customer> findByCountry(String keyword) throws SQLException {
        return null;
    }


    public List<Customer> selectAllCustomer() throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        List<Customer> customers = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = null;
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
               String customer_name = resultSet.getString("customer_name");
               String customer_birthday = resultSet.getString("customer_birthday");
               int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("Customer_email");
               String customer_address = resultSet.getString("customer_address");

                customer = new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address);
                customers.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public boolean deleteCustomer(int id) throws SQLException {
        boolean check;
        try (Connection connection = baseRepository.connectDataBase();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);) {
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
        }
        return check;
    }

    public boolean updateCustomer(int id, Customer customer) throws SQLException {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_BY_ID);
        preparedStatement.setInt(1, customer.getCustomer_type_id());
        preparedStatement.setString(2, customer.getCustomer_name());
        preparedStatement.setString(3, customer.getCustomer_birthday());
        preparedStatement.setInt(4, customer.getCustomer_gender());
        preparedStatement.setString(5, customer.getCustomer_id_card());
        preparedStatement.setString(6, customer.getCustomer_phone());
        preparedStatement.setString(7, customer.getCustomer_email());
        preparedStatement.setString(8, customer.getCustomer_address());
        preparedStatement.setInt(9, id);
        check = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        connection.close();
        return check;
    }

    public Customer getUserById(int id) throws SQLException {
        return null;
    }
}
