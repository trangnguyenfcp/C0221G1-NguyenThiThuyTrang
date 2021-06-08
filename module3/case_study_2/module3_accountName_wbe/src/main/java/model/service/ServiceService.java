package model.service;

import model.bean.Customer;
import model.bean.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ServiceService {
    public Map<String,String> insertService(Service service) throws SQLException;
    public Service selectService(int id) throws SQLException;
    public List<Service> selectAllServices() throws SQLException;
    public boolean deleteService(int id) throws SQLException;
    public boolean updateService(int id, Service service) throws SQLException;

}
