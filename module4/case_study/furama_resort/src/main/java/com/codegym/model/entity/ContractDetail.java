package com.codegym.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractDetailId;
    private int quantity;
    @ManyToOne()
    @JoinColumn(name = "attach_service_id", referencedColumnName = "attach_service_id")
    private AttachService attachService;
    @ManyToOne()
    @JoinColumn(name = "contract_id", referencedColumnName = "contract_id")
    private Contract contract;
    public ContractDetail(){

    }
    public ContractDetail(int quantity, AttachService attachService, Contract contract) {
        this.quantity = quantity;
        this.attachService = attachService;
        this.contract = contract;
    }

    public Long getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Long contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
