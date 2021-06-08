package model.service.implement;

import model.bean.Customer;
import model.bean.CustomerUsingService;
import model.repository.CustomerUsingServiceRepository;
import model.service.CustomerUsingServiceService;

import java.sql.SQLException;
import java.util.List;

public class CustomerUsingServiceServiceImp implements CustomerUsingServiceService {
    CustomerUsingServiceRepository customerUsingServiceRepository = new CustomerUsingServiceRepository();
    @Override
    public List<CustomerUsingService> selectAllCustomersUsingService() throws SQLException {
        return customerUsingServiceRepository.selectAllCustomer();
    }
}
