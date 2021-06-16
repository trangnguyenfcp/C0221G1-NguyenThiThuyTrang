package com.codegym.controller;

import com.codegym.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    CalculateService calculateService;
    @GetMapping(value = {"/"})
    public String input(){
        return "index";
    }
    @PostMapping("/calculate")
    public String calculate(@RequestParam(name = "sign",required = false) String sign, @RequestParam String number1, @RequestParam String number2, Model model){
        int num1 = Integer.parseInt(number1);
        int num2 = Integer.parseInt(number2);
        String result;
        result = calculateService.calculate(num1, num2, sign);
        model.addAttribute("result", result);
        return "result";
    }
}
