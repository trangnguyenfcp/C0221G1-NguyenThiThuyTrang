package com.example.model.service;

import com.example.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Long id);

    void save(Blog blog);

    void delete(Long id);
    Page<Blog> findAllByTittleContaining(String tittle, Pageable pageable);
    List<Blog> findAllBlogsByCategory(Long id);
}
