package com.example.model.service.implement;

import com.example.model.entity.Blog;
import com.example.model.entity.Category;
import com.example.model.repository.ICategoryRepository;
import com.example.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
            iCategoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
            iCategoryRepository.deleteById(id);
    }

    @Override
    public Page<Category> findAllByNameContaining(String name, Pageable pageable) {
        return iCategoryRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public List<Category> findAllCategoriesOfBlog() {
        return iCategoryRepository.findAllCategoriesOfBlog();
    }
}
