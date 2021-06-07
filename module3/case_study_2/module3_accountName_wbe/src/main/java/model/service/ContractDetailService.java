package model.service;

import model.bean.Contract;
import model.bean.ContractDetail;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ContractDetailService {
    public void insertContractDetail(ContractDetail contractDetail) throws SQLException;
    public List<ContractDetail> selectAllContractDetails() throws SQLException;
    public List<Integer> selectAllContractId() throws SQLException;
    public Map<Integer, String> selectAllAttachServiceId() throws SQLException;
}
