package com.codegym.dto;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Component
public class ProductDto {
    @Size(min = 5, max = 45, message = "number of characters from 5 to 45")
    private String name;
    @Min(value = 18, message = "age >= 18")
    private String price;
    @Size(min = 5, max = 45, message = "number of characters from 5 to 45")
    private String description;
    private String manufacturer;
    public ProductDto(){}
    public ProductDto(String name, String price, String description, String manufacturer) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
