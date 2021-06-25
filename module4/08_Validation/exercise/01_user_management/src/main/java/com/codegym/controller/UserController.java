package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.entity.User;
import com.codegym.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("")
    public String showCreateForm(Model model){
        model.addAttribute("userDto", new UserDto());
        return "index";
    }
    @PostMapping("")
    public String checkValidation(@ModelAttribute("userDto") @Valid UserDto userDto, BindingResult bindingResult, Model model){
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "index";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.save(user);
        return "result";
    }
}
