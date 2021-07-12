package com.codegym.dto;

import com.codegym.model.entity.Contract;
import com.codegym.model.entity.RentType;
import com.codegym.model.entity.ServiceType;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.List;
@Component
public class ServiceDto implements Validator{
    private Long serviceId;
    @NotEmpty(message = "Service Code can not be empty")
    @Pattern(regexp = "^DV-[\\d]{4}$",
            message = "Invalid Service Code")
    private String serviceCode;

    private String serviceName;
    @Min(value = 0, message = "area > 0")
    private double serviceArea;

    private double serviceCost;
    @Min(value = 0, message = "number of people > 0")
    private int serviceMaxPeople;

    private String standardRoom;
    private String description;
    private double poolArea;
    @Min(value = 0, message = "number of floors > 0")
    private int numberOfFloor;
    private RentType rentType;
    private ServiceType serviceType;
    private List<Contract> contracts;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(double serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
        if (!serviceDto.serviceCode.matches("^DV-[\\d]{4}$")){
            errors.rejectValue("serviceCode","service.serviceCode","Invalid format, example: DV-1234");
        }
        if (serviceDto.serviceArea <= 0){
            errors.rejectValue("serviceArea","service.serviceArea","Area > 0");
        }
    }
}
