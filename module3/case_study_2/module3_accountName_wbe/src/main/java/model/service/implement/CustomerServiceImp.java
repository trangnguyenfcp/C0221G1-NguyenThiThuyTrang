package model.service.implement;

import model.bean.Customer;
import model.common.Validate;
import model.repository.CustomerRepository;
import model.service.CustomerService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImp implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public Map<String, String> insertCustomer(Customer customer) throws SQLException {
        Map<String, String> mapMsg = new HashMap<>();
//        boolean check = true;
//        if ("".equals(customer.getCustomerPhone())) {
//            mapMsg.put("customerPhone", "Please input phone number");
//            check = false;
////            KH-1234
//        } else if (!customer.getCustomerCode().matches("^(\\(84\\)\\+|0)9[0|1][\\d]{7}$")) {
//            mapMsg.put("customerPhone", "Invalid phone number");
//            check = false;
//        }
//        if ("".equals(customer.getCustomerCode())) {
//            mapMsg.put("customerCode", "Please input code");
//            check = false;
////            KH-1234
//        } else if (!customer.getCustomerCode().matches("^KH-[\\d]{4}$")) {
//            mapMsg.put("customerCode", "Invalid code");
//            check = false;
//        }
//        if (check) {
//            customerRepository.insertCustomer(customer);
//        }
        mapMsg.put("customerCode",Validate.validateCustomerCode(customer.getCustomerCode()));
        mapMsg.put("customerPhone",Validate.validatePhone(customer.getCustomerPhone()));
        mapMsg.put("customerIdCard",Validate.validateIdCard(customer.getCustomerIdCard()));
        mapMsg.put("customerEmail",Validate.validateEmail(customer.getCustomerEmail()));
        int count = 0;
        for (String validate : mapMsg.values())
        {
            if (validate.equals("")){
                count++;
            }
        }
        if (count==mapMsg.size()){
            customerRepository.insertCustomer(customer);
        }
        return mapMsg;
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
    public Map<String, String> updateCustomer(int id, Customer customer) throws SQLException {
            Map<String, String> mapMsg = new HashMap<>();
            boolean check = true;
            if ("".equals(customer.getCustomerCode())) {
                mapMsg.put("customerCode", "Please input code");
                check = false;
//            KH-1234
            } else if (!customer.getCustomerCode().matches("^KH-[\\d]{4}$")) {
                mapMsg.put("customerCode", "Invalid code");
                check = false;
            }
            if (check) {
                customerRepository.updateCustomer(id,customer);
            }
            return mapMsg;
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
