package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.entity.Customer;
import com.codegym.model.entity.CustomerType;
import com.codegym.model.service.ICustomerService;
import com.codegym.model.service.ICustomerTypeService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/customer")
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
//    @GetMapping(value = { ""})
//    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search,
//                                      @PageableDefault(value = 2) Pageable pageable){
//
//        String searchValue = "";
//        if (search.isPresent()){
//            searchValue = search.get();
//        }
//
//        ModelAndView modelAndView = new ModelAndView("customer/list");
//        Page<Customer> customers = customerService.findCustomerByCustomerNameContaining(searchValue,pageable);
//        modelAndView.addObject("searchValue", searchValue);
//        modelAndView.addObject("customers",customers);
//      return modelAndView;
//    }
    @GetMapping(value = { ""})
    public ModelAndView listCustomers(@RequestParam("searchName") Optional<String> searchName,
                                      @RequestParam("searchBirthday") Optional<String> searchBirthday,
                                      @RequestParam("searchAddress") Optional<String> searchAddress,
                                      @PageableDefault(value = 2) Pageable pageable){

        String searchNameValue = "";
        String searchBirthdayValue = "";
        String searchAddressValue = "";
        if (searchName.isPresent() && searchBirthday.isPresent() && searchAddress.isPresent()){
            searchNameValue = searchName.get();
            searchBirthdayValue = searchBirthday.get();
            searchAddressValue = searchAddress.get();

        }
        Page<Customer> customers = customerService.findCustomer(searchNameValue, searchBirthdayValue, searchAddressValue, pageable);
        ModelAndView modelAndView = new ModelAndView("customer/listSearch");

        modelAndView.addObject("searchNameValue", searchNameValue);
        modelAndView.addObject("searchBirthdayValue", searchBirthdayValue);
        modelAndView.addObject("searchAddressValue", searchAddressValue);
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
    @GetMapping(value = "/create")
    public String showCreateForm(Model model){
        model.addAttribute("customer", new CustomerDto());
        return "customer/create";
    }
    @PostMapping(value = "/create")
    public String saveCustomer(Model model,@Valid @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult) {
        new CustomerDto().validate(customerDto,bindingResult);
        if (customerService.findByCustomerCode(customerDto.getCustomerCode())!=null){
            ObjectError error = new FieldError("customerDto", "customerCode", "Code is existed");
            bindingResult.addError(error);
        }
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customer", customerDto);
            model.addAttribute("message", "Created failed");

            return "customer/create";

        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        model.addAttribute("customer", new CustomerDto());
        model.addAttribute("message", "Created successful");
        return "customer/create";
    }
    @GetMapping(value = "/edit/{id}")
    public String showEditForm(Model model, @PathVariable("id") Long id){
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customerService.findById(id), customerDto);
        model.addAttribute("customer", customerDto);
        return "customer/edit";
    }
    @PostMapping(value = "/edit/{id}")
    public String editCustomer(Model model, @Validated @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult, @PathVariable("id") Long id) {
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customer", customerDto);
            return "customer/edit";
        }
        Customer customerAfter = new Customer();
        BeanUtils.copyProperties(customerDto, customerAfter);
        customerService.save(customerAfter);
        model.addAttribute("customer", customerDto);
        model.addAttribute("message", "Edit successful");
        return "customer/edit";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Long id){
        this.customerService.deleteCustomer(id);
        return "redirect:/customer/";
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
