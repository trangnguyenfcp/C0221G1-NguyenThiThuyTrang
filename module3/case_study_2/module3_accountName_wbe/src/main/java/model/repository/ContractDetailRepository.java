package model.repository;

import model.bean.Contract;
import model.bean.ContractDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractDetailRepository {
    BaseRepository baseRepository = new BaseRepository();
    public static final String INSERT_NEW_CONTRACT_DETAIL = "insert into contract_detail\n" +
            "value(?,?,?,?);";
    public static final String SELECT_ALL_CONTRACT_DETAILS = "select* from contract_detail;";
    public static final String SELECT_ALL_CONTRACT_ID = "select contract_id from contract;";
    public static final String SELECT_ALL_ATTACH_SERVICE_ID = "select attach_service_id, attach_service_name from attach_service;";

    public void insertContractDetail(ContractDetail contractDetail) throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_CONTRACT_DETAIL);
        preparedStatement.setInt(1, contractDetail.getContractDetailId());
        preparedStatement.setInt(2, contractDetail.getContractId());
        preparedStatement.setInt(3, contractDetail.getAttachServiceId());
        preparedStatement.setInt(4, contractDetail.getQuantity());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public List<Integer> selectAllContractId() throws SQLException {
       List<Integer> contractIds = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contractId = resultSet.getInt("contract_id");
                contractIds.add(contractId);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractIds;
    }

    public Map<Integer, String> selectAllAttachServiceId() throws SQLException {
        Map<Integer, String> attachServices = new HashMap<>();
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_ATTACH_SERVICE_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int attachServiceId = resultSet.getInt("attach_service_id");
                String attachServiceName = resultSet.getString("attach_service_name");
                attachServices.put(attachServiceId, attachServiceName);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attachServices;
    }


    public List<ContractDetail> selectAllContractDetails() throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        List<ContractDetail> contractDetails = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAILS);
            ResultSet resultSet = preparedStatement.executeQuery();
            ContractDetail contractDetail = null;
            while (resultSet.next()) {
                int contractDetailId = resultSet.getInt("contract_detail_id");
                int contractId = resultSet.getInt("contract_id");
                int attachServiceId = resultSet.getInt("attach_service_id");
                int quantity = resultSet.getInt("quantity");
                contractDetail = new ContractDetail(contractDetailId, contractId, attachServiceId, quantity);
                contractDetails.add(contractDetail);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractDetails;
    }
}
