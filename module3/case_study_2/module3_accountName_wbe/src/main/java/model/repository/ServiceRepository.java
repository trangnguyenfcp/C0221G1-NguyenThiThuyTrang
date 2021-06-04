package model.repository;

import model.bean.Customer;
import model.bean.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    public static final String INSERT_NEW_SERVICE = "insert into service\n" +
            "value(?,?,?,?,?,?,?,?,?,?,?);";
    public static final String SELECT_ALL_SERVICES = "select* from service;";

    public void insertService(Service service) throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_SERVICE);

        preparedStatement.setInt(1, service.getServiceId());
        preparedStatement.setString(2, service.getServiceName());
        preparedStatement.setInt(3, service.getServiceArea());
        preparedStatement.setDouble(4, service.getServiceCost());
        preparedStatement.setInt(5, service.getNumberOfFloors());
        preparedStatement.setInt(6, service.getServiceMaxPeople());
        preparedStatement.setInt(7, service.getRentTypeId());
        preparedStatement.setDouble(8, service.getPoolArea());
        preparedStatement.setString(9, service.getStandardRoom());
        preparedStatement.setString(10, service.getDescriptionOtherConvenience());
        preparedStatement.setInt(11, service.getRentTypeId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();

    }


    public Service selectService(int id) throws SQLException {
        return null;
    }


    public List<Service> selectAllServices() throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        List<Service> services = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICES);
            ResultSet resultSet = preparedStatement.executeQuery();
            Service service = null;
            while (resultSet.next()) {
                int serviceID = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                int serviceArea = resultSet.getInt("service_area");
                double serviceCost = resultSet.getDouble("service_cost");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                int serviceTypeId= resultSet.getInt("service_type_id");
                double poolArea = resultSet.getDouble("pool_area");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                int rentTypeId = resultSet.getInt("rent_type_id");
                service = new Service(serviceID, serviceName, serviceArea, serviceCost, numberOfFloors, serviceMaxPeople, serviceTypeId, poolArea, standardRoom,descriptionOtherConvenience,rentTypeId);
                services.add(service);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }


    public boolean deleteService(int id) throws SQLException {
        return false;
    }


    public boolean updateService(int id, Service service) throws SQLException {
        return false;
    }
}
