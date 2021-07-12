package com.codegym.controller;

import com.codegym.model.entity.*;
import com.codegym.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("employee")
@RequestMapping(value = "/employee")
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
    @ModelAttribute("cart")
    public Employee setupEmployee() {
        return new Employee();
    }
    @GetMapping(value = "/create")
    public String showCreateForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }
    @PostMapping(value = "/create")
    public String saveEmployee(Model model, @ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        model.addAttribute("employee", new Employee());
        model.addAttribute("message", "Created successful");
        return "employee/create";
    }
    @GetMapping(value = "")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, @PageableDefault(value = 2) Pageable pageable){
       String searchValue = "";
        if (search.isPresent()){
            searchValue = search.get();
        }
        Page<Employee> employees = employeeService.findCustomerByEmployeeNameContaining(searchValue, pageable);
        ModelAndView modelAndView = new ModelAndView("employee/list");
        modelAndView.addObject("searchValue", searchValue);
        modelAndView.addObject("employees",employees);
        return modelAndView;
    }
}
