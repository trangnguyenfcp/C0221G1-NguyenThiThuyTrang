package com.example.model.service;

import com.example.model.entity.Blog;
import com.example.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);

    Category findById(Long id);

    void save(Category category);

    void delete(Long id);
    Page<Category> findAllByNameContaining(String name, Pageable pageable);
}
