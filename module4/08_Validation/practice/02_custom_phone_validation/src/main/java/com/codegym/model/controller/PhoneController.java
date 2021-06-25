package com.codegym.model.controller;

import com.codegym.model.entity.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "index";
    }
    @PostMapping("")
    public String checkValidation ( @ModelAttribute("phoneNumber") @Valid PhoneNumber phoneNumber, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasErrors()){
            return "index";
        }
        else {
            model.addAttribute("phoneNumber", phoneNumber);
            return "result";
        }
    }}
