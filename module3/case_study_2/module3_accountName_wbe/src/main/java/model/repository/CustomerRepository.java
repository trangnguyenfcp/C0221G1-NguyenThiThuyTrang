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
    public static final String FIND_BY_NAME = "select* from customer\n" +
            "where customer_name like ?;";


    public void insertCustomer(Customer customer) throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_CUSTOMER);
        preparedStatement.setInt(1, customer.getCustomerId());
        preparedStatement.setInt(2, customer.getCustomerTypeId());
        preparedStatement.setString(3, customer.getCustomerName());
        preparedStatement.setString(4, customer.getCustomerBirthday());
        preparedStatement.setInt(5, customer.getCustomerGender());
        preparedStatement.setString(6, customer.getCustomerIdCard());
        preparedStatement.setString(7, customer.getCustomerPhone());
        preparedStatement.setString(8, customer.getCustomerEmail());
        preparedStatement.setString(9, customer.getCustomerAddress());
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
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("Customer_email");
                String customerAddress = resultSet.getString("customer_address");
                customer = new Customer(id, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }


    public List<Customer> findByName(String keyword) throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        List<Customer> customers = new ArrayList<>();
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("Customer_email");
                String customerAddress = resultSet.getString("customer_address");
                customer = new Customer(customerId, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
                customers.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
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
                int customerId = resultSet.getInt("customer_id");
                int customerTypeId = resultSet.getInt("customer_type_id");
               String customerName = resultSet.getString("customer_name");
               String customerBirthday = resultSet.getString("customer_birthday");
               int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("Customer_email");
               String customerAddress = resultSet.getString("customer_address");

                customer = new Customer(customerId, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
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
        preparedStatement.setInt(1, customer.getCustomerTypeId());
        preparedStatement.setString(2, customer.getCustomerName());
        preparedStatement.setString(3, customer.getCustomerBirthday());
        preparedStatement.setInt(4, customer.getCustomerGender());
        preparedStatement.setString(5, customer.getCustomerIdCard());
        preparedStatement.setString(6, customer.getCustomerPhone());
        preparedStatement.setString(7, customer.getCustomerEmail());
        preparedStatement.setString(8, customer.getCustomerAddress());
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
