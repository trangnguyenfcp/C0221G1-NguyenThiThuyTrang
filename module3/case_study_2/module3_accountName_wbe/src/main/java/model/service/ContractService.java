package model.service;

import model.bean.Contract;
import model.bean.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ContractService {
    public void insertContract(Contract contract) throws SQLException;
    public Contract selectService(int id) throws SQLException;
    public List<Contract> selectAllContracts() throws SQLException;
    public Map<Integer, String> selectAllEmployeeId() throws SQLException;
    public Map<Integer, String> selectAllCustomerId() throws SQLException;
    public Map<Integer, String> selectAllServiceId() throws SQLException;
    public boolean deleteContract(int id) throws SQLException;
    public boolean updateContract(int id, Contract contract) throws SQLException;
}
