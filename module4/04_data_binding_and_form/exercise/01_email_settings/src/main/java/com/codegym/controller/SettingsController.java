package com.codegym.controller;

import com.codegym.model.bean.Settings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettingsController {
    @GetMapping(value = "/")
    public java.lang.String settings(Model model ){
        model.addAttribute("settings", new Settings());
        model.addAttribute("languages", new String[]{"English","Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new String[]{"5","10", "15", "25", "50", "100"});
        return "settings";
    }
    @PostMapping(value = "/create")
    public String create(@ModelAttribute("settings") Settings settings, Model model){
        model.addAttribute("settings", settings);
        return "display";
    }
}
