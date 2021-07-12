package com.codegym.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "customer_code")
    private String customerCode;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_birthday", columnDefinition = "DATE")
    private String customerBirthday;
    @Column(name = "customer_gender")
    private String customerGender;
    @Column(name = "customer_id_card")
    private String customerIdCard;
    @Column(name = "customer_phone")
    private String customerPhone;
    @Column(name = "customer_email")
    private String customerEmail;
    @Column(name = "customer_address")
    private String customerAddress;
    private int flag=1;
    @ManyToOne()
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")
    private CustomerType customerType;
    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Customer(){

    }
    public Customer(Long id){
            this.customerId = id;
    }
    public Customer(String customerCode, String customerName, String customerBirthday, String customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, CustomerType customerType, int flag) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerType = customerType;
        this.flag = flag;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
