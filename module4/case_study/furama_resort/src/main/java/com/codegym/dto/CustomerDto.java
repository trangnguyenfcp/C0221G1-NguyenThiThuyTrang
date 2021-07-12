package com.codegym.dto;

import com.codegym.model.entity.Contract;
import com.codegym.model.entity.CustomerType;
import com.codegym.model.repository.ICustomerRepository;
import com.codegym.model.service.ICustomerService;
import com.codegym.model.service.implement.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.List;
@Component
public class CustomerDto implements Validator {

    private Long customerId;
    @NotEmpty(message = "Customer Code can not be empty")
    @Pattern(regexp = "^KH-[\\d]{4}$",
    message = "Invalid Customer Code")
    private String customerCode;
    private String customerName;
    @NotEmpty(message = "Birthday can not be empty")
    private String customerBirthday;
    private String customerGender;
    @NotEmpty(message = "ID Card can not be empty")
    @Pattern(regexp = "^([\\d]{9}|[\\d]{12})$",
            message = "Invalid ID Card")
    private String customerIdCard;
    @NotEmpty(message = "Customer Phone can not be empty")
    @Pattern(regexp = "^(\\(84\\)\\+|0)9[0|1][\\d]{7}$",
            message = "Invalid Phone Number")
    private String customerPhone;
    @NotEmpty(message = "Email can not be empty")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
            message = "Invalid Email")
    private String customerEmail;
    private String customerAddress;
    private int flag=1;
    private CustomerType customerType;
    private List<Contract> contracts;

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerService customerService = new CustomerService();
        CustomerDto customerDto = (CustomerDto) target;
        try {
            Date birthday1;
            LocalDate birthDate;
            LocalDate now;
            birthday1 = new SimpleDateFormat("yyyy-MM-dd").parse(customerDto.customerBirthday);
            Instant instant = birthday1.toInstant();
            birthDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
            now = java.time.LocalDate.now();
            if (Period.between(birthDate,now).getYears()<=18){
                errors.rejectValue("customerBirthday", "cus.birthday.afterCurrent", "invalid Date");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
