package model.service.implement;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.service.CustomerService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CustomerServiceImp implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public void insertCustomer(Customer customer) throws SQLException {
            customerRepository.insertCustomer(customer);
    }

    @Override
    public Customer selectCustomer(int id) throws SQLException {
        return customerRepository.selectCustomer(id);
    }

    @Override
    public List<Customer> findByName(String keyword) throws SQLException {
        return customerRepository.findByName(keyword);
    }

    @Override
    public List<Customer> selectAllCustomers() throws SQLException {
        return customerRepository.selectAllCustomer();
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(int id, Customer customer) throws SQLException {
        return customerRepository.updateCustomer(id, customer);
    }

    @Override
    public Customer getUserById(int id) throws SQLException {
        return null;
    }

    @Override
    public Map<Integer, String> selectAllCustomerTypes() throws SQLException {
        return customerRepository.selectAllCustomerTypes();
    }
}
