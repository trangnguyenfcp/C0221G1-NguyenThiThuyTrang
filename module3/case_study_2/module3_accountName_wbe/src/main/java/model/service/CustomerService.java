package model.service;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    public void insertCustomer(Customer customer) throws SQLException;
    public Customer selectCustomer(int id) throws SQLException;
    public List<Customer> findByCountry(String keyword) throws SQLException;
    public List<Customer> selectAllCustomers() throws SQLException;
    public boolean deleteCustomer(int id) throws SQLException;
    public boolean updateCustomer(int id, Customer service) throws SQLException;
    public Customer getUserById(int id) throws SQLException;
}
