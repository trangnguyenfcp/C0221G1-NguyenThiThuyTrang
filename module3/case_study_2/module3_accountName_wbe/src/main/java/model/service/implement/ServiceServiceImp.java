package model.service.implement;

import model.bean.Service;
import model.repository.ServiceRepository;
import model.service.ServiceService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceServiceImp implements ServiceService {
    ServiceRepository serviceRepository = new ServiceRepository();
    @Override
    public Map<String, String> insertService(Service service) throws SQLException {
        Map<String, String> mapMsg = new HashMap<>();
        boolean check = true;
        if ("".equals(service.getServiceCode())) {
            mapMsg.put("serviceCode", "Please input code");
            check = false;
//            KH-1234
        } else if (!service.getServiceCode().matches("^DV-[\\d]{4}$")) {
            mapMsg.put("serviceCode", "Invalid code");
            check = false;
        }
        if (check) {
            serviceRepository.insertService(service);
        }
        return mapMsg;

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
