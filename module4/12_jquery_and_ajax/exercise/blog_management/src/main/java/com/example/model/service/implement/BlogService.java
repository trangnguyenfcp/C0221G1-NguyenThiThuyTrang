package com.example.model.service.implement;

import com.example.model.entity.Blog;
import com.example.model.repository.IBlogRepository;
import com.example.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Long id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
    iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByTittleContaining(String tittle, Pageable pageable) {
        return iBlogRepository.findAllByTittleContaining(tittle,pageable);
    }

    @Override
    public List<Blog> findAllBlogsByCategory(Long id) {
        return iBlogRepository.findAllBlogsByCategory(id);
    }

    @Override
    public List<Blog> findAllByTittleContaining(String tittle) {
        return iBlogRepository.findAllByTittleContaining(tittle);
    }
}
