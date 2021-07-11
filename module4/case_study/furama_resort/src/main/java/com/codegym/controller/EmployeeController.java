package com.codegym.controller;

import com.codegym.model.entity.*;
import com.codegym.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPositionService positionService;
    @Autowired
    private IEducationDegreeService educationDegreeService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    private IUsernameService usernameService;
    @ModelAttribute("positions")
    public Iterable<Position> positions(){
        return positionService.findAll();
    }
    @ModelAttribute("educationDegrees")
    public Iterable<EducationDegree> educationDegrees(){
        return educationDegreeService.findAll();
    }
    @ModelAttribute("divisions")
    public Iterable<Division> divisions(){
        return divisionService.findAll();
    }
    @ModelAttribute("usernames")
    public Iterable<Username> usernames(){
        return usernameService.findAll();
    }
    @GetMapping(value = "create-employee")
    public String showCreateForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }
    @PostMapping(value = "create-employee")
    public String saveEmployee(Model model, @ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        model.addAttribute("employee", new Employee());
        model.addAttribute("message", "Created successful");
        return "employee/create";
    }
    @GetMapping(value = "employee")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, @PageableDefault(value = 2) Pageable pageable){
        Page<Employee> employees;
        if (search.isPresent()){
            employees = employeeService.findCustomerByEmployeeNameContaining(search.get(),pageable);
        }else {
            employees = employeeService.findAll(pageable);
        }

        ModelAndView modelAndView = new ModelAndView("employee/list");
        modelAndView.addObject("employees",employees);
        return modelAndView;
    }
}
