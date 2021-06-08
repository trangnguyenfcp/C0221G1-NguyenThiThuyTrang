package model.service;

import model.bean.Customer;
import model.bean.CustomerUsingService;

import java.sql.SQLException;
import java.util.List;

public interface CustomerUsingServiceService {
    public List<CustomerUsingService> selectAllCustomersUsingService() throws SQLException;
}
