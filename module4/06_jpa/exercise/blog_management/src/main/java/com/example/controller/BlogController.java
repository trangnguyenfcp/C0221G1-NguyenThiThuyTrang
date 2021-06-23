package com.example.controller;

import com.example.model.service.IBlogService;
import com.example.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    ICategoryService categoryService;
}
