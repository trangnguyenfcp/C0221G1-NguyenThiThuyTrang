package model.service.implement;

import model.bean.ContractDetail;
import model.repository.ContractDetailRepository;
import model.service.ContractDetailService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ContractDetailServiceImp implements ContractDetailService {
    ContractDetailRepository contractDetailRepository = new ContractDetailRepository();
    @Override
    public void insertContractDetail(ContractDetail contractDetail) throws SQLException {
            contractDetailRepository.insertContractDetail(contractDetail);
    }


    @Override
    public List<ContractDetail> selectAllContractDetails() throws SQLException {
        return contractDetailRepository.selectAllContractDetails();
    }

    @Override
    public List<Integer> selectAllContractId() throws SQLException {
        return contractDetailRepository.selectAllContractId();
    }

    @Override
    public Map<Integer, String> selectAllAttachServiceId() throws SQLException {
        return contractDetailRepository.selectAllAttachServiceId();
    }
}
