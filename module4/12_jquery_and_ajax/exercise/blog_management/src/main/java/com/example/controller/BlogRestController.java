package com.example.controller;

import com.example.model.entity.Blog;
import com.example.model.entity.Category;
import com.example.model.service.IBlogService;
import com.example.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class BlogRestController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;
    @GetMapping(value = "/blogs")
    public ResponseEntity<Page<Blog>> findAllBlogs(Pageable pageable){
        Page<Blog> blogs = blogService.findAll(pageable);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @GetMapping(value = "/categories")
    public ResponseEntity<Iterable<Category>> findAllCategories(Pageable pageable){
        Page<Category> categories = categoryService.findAll(pageable);
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
    @GetMapping(value = "/blog/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
    @GetMapping(value = "/blog/category/{id}")
    public ResponseEntity<List<Blog>> findBlogByCategory(@PathVariable Long id){
        List<Blog> blogs = blogService.findAllBlogsByCategory(id);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    @GetMapping(value = "/blog/search/{keyword}")
    public ResponseEntity<List<Blog>> findBlogByTittle(@PathVariable String keyword){
        List<Blog> blogs = blogService.findAllByTittleContaining(keyword);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    @GetMapping(value = "/blogs/{page}")
    public ResponseEntity<Page<Blog>> findPaginated(@PathVariable int page ){
        Page<Blog> resultPage = blogService.findAll(PageRequest.of(page,2));
        if (resultPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }
}
