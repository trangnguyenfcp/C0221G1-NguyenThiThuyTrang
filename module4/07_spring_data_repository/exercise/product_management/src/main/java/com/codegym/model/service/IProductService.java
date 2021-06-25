package com.codegym.model.service;

import com.codegym.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    void save(Product product);

    Product findById(Long id);


    void delete(Long id);
    Page<Product> findAllByNameContaining(String name, Pageable pageable);

}
