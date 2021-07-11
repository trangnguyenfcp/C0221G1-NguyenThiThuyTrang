package com.codegym.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long contractId;
    @Column(name = "contract_start_date", columnDefinition = "DATETIME")
    private String contractStartDate;
    @Column(name = "contract_end_date", columnDefinition = "DATETIME")
    private String contractEndDate;
    @Column(name = "contract_deposit")
    private double contractDeposit;
    @Column(name = "contract_total_money")
    private double contractTotalMoney;
    @OneToMany(mappedBy = "contract")
    private List<ContractDetail> contractDetails;
    @ManyToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;
    @ManyToOne()
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;
    @ManyToOne()
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Service service;
    public Contract(){

    }
    public Contract(String contractStartDate, String contractEndDate, double contractDeposit, double contractTotalMoney, List<ContractDetail> contractDetails, Customer customer, Employee employee, Service service) {
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.contractDetails = contractDetails;
        this.customer = customer;
        this.employee = employee;
        this.service = service;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
