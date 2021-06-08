package model.service;

import model.bean.Customer;
import model.bean.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CustomerService {
    public Map<String, String> insertCustomer(Customer customer) throws SQLException;
    public Customer selectCustomer(int id) throws SQLException;
    public List<Customer> findByName(String keyword) throws SQLException;
    public List<Customer> selectAllCustomers() throws SQLException;
    public boolean deleteCustomer(int id) throws SQLException;
    public Map<String, String> updateCustomer(int id, Customer customer) throws SQLException;
    public Customer getUserById(int id) throws SQLException;
    public Map<Integer, String> selectAllCustomerTypes() throws SQLException;

}
