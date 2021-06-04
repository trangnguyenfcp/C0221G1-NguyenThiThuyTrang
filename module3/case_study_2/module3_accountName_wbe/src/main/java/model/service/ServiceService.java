package model.service;

import model.bean.Customer;
import model.bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceService {
    public void insertService(Service service) throws SQLException;
    public Service selectService(int id) throws SQLException;
    public List<Service> selectAllServices() throws SQLException;
    public boolean deleteService(int id) throws SQLException;
    public boolean updateService(int id, Service service) throws SQLException;

}
