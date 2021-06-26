package com.example.controller;

import com.example.model.entity.Blog;
import com.example.model.entity.BlogCategory;
import com.example.model.entity.Category;
import com.example.model.entity.DAO;
import com.example.model.service.IBlogService;
import com.example.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> provinces() {
        return categoryService.findAll();
    }

    @GetMapping("/blogs")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, Pageable pageable) {
        Page<Blog> blogs;
        if (search.isPresent()) {
            blogs = blogService.findAllByTittleContaining(search.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("dao", new DAO());


        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveCustomer(@ModelAttribute("dao") DAO dao) {
        Blog blog = new Blog(dao.getTittle(), dao.getSummary(), dao.getContent());
        blogService.save(blog);
        Set<Category> categories = new HashSet<>();
        for (String id : dao.getBlogCategories()) {
            categories.add(categoryService.findById(Long.parseLong(id)));
        }
        blog.setBlogCategories(categories);
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);

        Set<Category> categorySet = blog.getBlogCategories();
        String[] categories = new String[categorySet.size()];

        DAO dao = new DAO(blog.getTittle(), blog.getSummary(), blog.getContent(), categories);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("blog/edit");
            modelAndView.addObject("dao", dao);
            modelAndView.addObject("categories", categoryService.findAll());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateCustomer(@ModelAttribute("dao") DAO dao) {
        Blog blog = new Blog(dao.getTittle(), dao.getSummary(), dao.getContent());
        Set<Category> categories = new HashSet<>();
        for (String id : dao.getBlogCategories()) {
            categories.add(categoryService.findById(Long.parseLong(id)));
        }
        blog.setBlogCategories(categories);
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("dao", dao);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String deleteCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.delete(blog.getId());
        return "redirect:blogs";
    }
}
