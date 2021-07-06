package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FuramaResortController {
    @RequestMapping(value = "/home")
    public String goHome(){
        return "home";
    }
}
