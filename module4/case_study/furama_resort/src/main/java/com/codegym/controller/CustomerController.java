package com.codegym.controller;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.CustomerType;
import com.codegym.model.service.ICustomerService;
import com.codegym.model.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller

public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;
    @ModelAttribute("customerTypes")
    public Iterable<CustomerType> customerTypes(){
        return customerTypeService.findAll();
    }
    @RequestMapping(value = "")
    public String goHome(){
        return "home";
    }
    @GetMapping(value = "customer")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, @PageableDefault(value = 2) Pageable pageable){
        Page<Customer> customers;
        if (search.isPresent()){
            customers = customerService.findCustomerByCustomerNameContaining(search.get(),pageable);
        }else {
            customers = customerService.findAll(pageable);
        }

        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers",customers);
      return modelAndView;
    }
    @GetMapping(value = "create-customer")
    public String showCreateForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }
    @PostMapping(value = "create-customer")
    public String saveCustomer(Model model, @ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        model.addAttribute("customer", new Customer());
        model.addAttribute("message", "Created successful");
        return "customer/create";
    }
    @GetMapping(value = "/customer-type/{id}")
    public String test(Model model, @PathVariable("id") Long id){
        Iterable<CustomerType> customerTypes = customerTypeService.findAll();
        List<Long> customerIds = customerTypeService.findAllCustomersOfCustomerType(id);
        List<Customer> customerList = new ArrayList<>();
        for(Long customerId: customerIds){
            Customer customer = customerService.findById(customerId);
            if (customer!= null){
                customerList.add(customer);
            }
        }
        model.addAttribute("customerTypes", customerTypes);
        model.addAttribute("customerList", customerList);
        return "customer_type/test";
    }
}
