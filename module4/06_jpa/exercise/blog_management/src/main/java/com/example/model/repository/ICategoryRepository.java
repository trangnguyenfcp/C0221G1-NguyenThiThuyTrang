package com.example.model.repository;

import com.example.model.entity.Blog;
import com.example.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long> {
    Page<Category> findAllByNameContaining(String name, Pageable pageable);
}
