package com.codegym.controller;

import com.codegym.model.entity.*;
import com.codegym.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IServiceService serviceService;
    @ModelAttribute("services")
    public Iterable<Service> services(){
        return serviceService.findAll();
    }
    @ModelAttribute("customers")
    public Iterable<Customer> customers(){
        return customerService.findAll();
    }
    @ModelAttribute("employees")
    public Iterable<Employee> employees(){
        return employeeService.findAll();
    }
    @GetMapping(value = "create-contract")
    public String showCreateForm(Model model){
        model.addAttribute("contract", new Contract());
        return "contract/create";
    }
    @PostMapping(value = "create-contract")
    public String saveCustomer(Model model, @ModelAttribute("contract") Contract contract) {
        contractService.save(contract);
        model.addAttribute("contract", new Contract());
        model.addAttribute("message", "Created successful");
        return "contract/create";
    }
}
