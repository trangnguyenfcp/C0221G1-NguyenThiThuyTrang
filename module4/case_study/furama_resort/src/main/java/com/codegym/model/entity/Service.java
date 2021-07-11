package com.codegym.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;
    @Column(name = "service_code")
    private String serviceCode;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "service_area")
    private double serviceArea;
    @Column(name = "service_cost")
    private double serviceCost;
    @Column(name = "service_max_people")
    private int serviceMaxPeople;
    @Column(name = "standard_room")
    private String standardRoom;
    private String description;
    @Column(name = "pool_area")
    private double poolArea;
    @Column(name = "number_of_floor")
    private int numberOfFloor;
    @ManyToOne()
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rent_type_id")
    private RentType rentType;
    @ManyToOne()
    @JoinColumn(name = "service_type_id", referencedColumnName = "service_type_id")
    private ServiceType serviceType;
    @OneToMany(mappedBy = "service")
    private List<Contract> contracts;

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Service(){

    }
    public Service(String serviceCode, String serviceName, double serviceArea, double serviceCost, int serviceMaxPeople, String standardRoom, String description, double poolArea, int numberOfFloor, RentType rentType, ServiceType serviceType) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
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

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
