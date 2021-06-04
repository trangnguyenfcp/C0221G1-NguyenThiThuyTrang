package model.service.implement;

import model.bean.Service;
import model.repository.ServiceRepository;
import model.service.ServiceService;

import java.sql.SQLException;
import java.util.List;

public class ServiceServiceImp implements ServiceService {
    ServiceRepository serviceRepository = new ServiceRepository();
    @Override
    public void insertService(Service service) throws SQLException {
            serviceRepository.insertService(service);
    }

    @Override
    public Service selectService(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Service> selectAllServices() throws SQLException {
        return serviceRepository.selectAllServices();
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateService(int id, Service service) throws SQLException {
        return false;
    }
}
