package com.example.model.service;

import com.example.model.entity.Customer;
import com.example.model.entity.Province;

public interface IProvinceService {
    Iterable<Province> findAll();
    Province findById(Long id);
    void save(Province province);

    void delete(Long id);
}
