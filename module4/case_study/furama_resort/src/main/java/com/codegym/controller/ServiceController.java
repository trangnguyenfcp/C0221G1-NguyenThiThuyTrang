package com.codegym.controller;

import com.codegym.model.entity.*;
import com.codegym.model.service.IRentTypeService;
import com.codegym.model.service.IServiceService;
import com.codegym.model.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServiceController {
    @Autowired
    private IServiceService serviceService;
    @Autowired
    private IServiceTypeService serviceTypeService;
    @Autowired
    private IRentTypeService rentTypeService;
    @ModelAttribute("serviceTypes")
    public Iterable<ServiceType> serviceTypes(){
        return serviceTypeService.findAll();
    }
    @ModelAttribute("rentTypes")
    public Iterable<RentType> rentTypes(){
        return rentTypeService.findAll();
    }
    @GetMapping(value = "create-service")
    public String showCreateForm(Model model){
        model.addAttribute("service", new Service());
        return "service/create";
    }
    @PostMapping(value = "create-service")
    public String saveCustomer(Model model, @ModelAttribute("service") Service service) {
        serviceService.save(service);
        model.addAttribute("service", new Service());
        model.addAttribute("message", "Created successful");
        return "service/create";
    }
}
