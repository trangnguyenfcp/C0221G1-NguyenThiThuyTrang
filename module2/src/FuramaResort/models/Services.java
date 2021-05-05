package FuramaResort.models;

import java.io.Serializable;
import java.util.List;

public abstract class Services {
    private String id;
    private String service;
    private double usableArea;
    private double rentalCost;
    private int maximumInHouse;
    private String rentalPeriod;
    public Services(){}
    public Services(String id, String service, Double usableArea, long rentalCost, int maximumInHouse, String rentalPeriod){
        this.id = id;
        this.service = service;
        this.usableArea = usableArea;
        this.rentalCost = rentalCost;
        this.maximumInHouse = maximumInHouse;
        this.rentalPeriod = rentalPeriod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(long rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaximumInHouse() {
        return maximumInHouse;
    }

    public void setMaximumInHouse(int maximumInHouse) {
        this.maximumInHouse = maximumInHouse;
    }

    public String getRentalPeriod() {
        return rentalPeriod;
    }

    public void setRentalPeriod(String rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }

    public abstract String showInfor();

}
