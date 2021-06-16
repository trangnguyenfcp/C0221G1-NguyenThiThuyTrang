package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentController {
    @RequestMapping(value = {"/"})
    public String chooseCondiments() {
        return "index";
    }
    @RequestMapping(value = {"/save"})
    public String save(@RequestParam("condiment") String[] condiments, Model model) {
        model.addAttribute("condiments",condiments);
        return "result";
    }
}
