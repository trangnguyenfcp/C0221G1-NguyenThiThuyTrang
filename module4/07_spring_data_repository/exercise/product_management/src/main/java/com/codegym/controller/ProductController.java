package com.codegym.controller;

import com.codegym.model.entity.Product;
import com.codegym.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("")
    public String listProducts(Model model, @RequestParam("search") Optional<String> search, Pageable pageable) {
        Page<Product> products;
        if (search.isPresent()){
            products = productService.findAllByNameContaining(search.get(),pageable);
        }else {
            products = productService.findAll(pageable);
        }
        model.addAttribute("products", products);
        return "list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute("product") Product product, Model model) {
        productService.save(product);
        model.addAttribute("product", product);
        model.addAttribute("message", "New product created successfully");
        return "list";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        if (product!= null){
        model.addAttribute("product",product);
        return "edit";}else {
            return "error";
        }
    }
    @PostMapping("/edit")
    public String update(@ModelAttribute("product") Product product, Model model) {
        productService.save(product);
        model.addAttribute("product", product);
        model.addAttribute("message", "Product updated successfully");
        return "edit";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("product", product);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("product") Product product) {
        productService.delete(product.getId());
        return "redirect:product";
    }
}
