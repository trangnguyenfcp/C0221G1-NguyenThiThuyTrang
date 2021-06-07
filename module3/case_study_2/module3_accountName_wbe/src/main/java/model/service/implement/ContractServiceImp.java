package model.service.implement;

import model.bean.Contract;
import model.repository.ContractRepository;
import model.service.ContractService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ContractServiceImp implements ContractService {
    ContractRepository contractRepository = new ContractRepository();

    @Override
    public Map<Integer, String> selectAllCustomerId() throws SQLException {
        return contractRepository.selectAllCustomerId();
    }

    @Override
    public Map<Integer, String> selectAllServiceId() throws SQLException {
        return contractRepository.selectAllServiceId();
    }

    @Override
    public void insertContract(Contract contract) throws SQLException {
            contractRepository.insertService(contract);
    }

    @Override
    public Contract selectService(int id) throws SQLException {
        return null;
    }

    @Override
    public Map<Integer, String> selectAllEmployeeId() throws SQLException {
        return contractRepository.selectAllEmployeeId();
    }

    @Override
    public List<Contract> selectAllContracts() throws SQLException {
        return contractRepository.selectAllContracts();
    }

    @Override
    public boolean deleteContract(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateContract(int id, Contract contract) throws SQLException {
        return false;
    }
}
