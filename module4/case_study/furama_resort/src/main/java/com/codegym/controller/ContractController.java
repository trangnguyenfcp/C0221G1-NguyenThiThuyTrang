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
@RequestMapping (value= "/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IServiceService serviceService;
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IAttachServiceService attachServiceService;
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
    @ModelAttribute("contractDetails")
    public Iterable<ContractDetail> contractDetails(){
        return contractDetailService.findAll();
    }
    @ModelAttribute("attachServices")
    public Iterable<AttachService> attachServices(){
        return attachServiceService.findAll();
    }
    @GetMapping(value = "/create")
    public String showCreateForm(Model model){
        model.addAttribute("contract", new Contract());
        return "contract/create";
    }
    @GetMapping(value = { ""})
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search,
                                      @PageableDefault(value = 2) Pageable pageable){

        String searchValue = "";
        if (search.isPresent()){
            searchValue = search.get();
        }

        ModelAndView modelAndView = new ModelAndView("contract/listCustomerUsingService");
        Page<Contract> contracts = contractService.findAllByCustomerName(searchValue,pageable);
        modelAndView.addObject("searchValue", searchValue);
        modelAndView.addObject("contracts",contracts);
      return modelAndView;
    }
    @PostMapping(value = "/create")
    public String saveCustomer(Model model, @ModelAttribute("contract") Contract contract) {
        contractService.save(contract);
        model.addAttribute("contract", new Contract());
        model.addAttribute("message", "Created successful");
        return "contract/create";
    }
}
