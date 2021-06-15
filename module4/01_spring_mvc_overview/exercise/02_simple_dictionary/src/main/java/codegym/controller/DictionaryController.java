package codegym.controller;

import codegym.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
   @Autowired
    private TranslateService translateService;
    @GetMapping(value = {"/"})
    public String input(Model model) {
        return "input";
    }

    @PostMapping(value = {"/translate"})
    public String currencyExchange(@RequestParam String word,
                                   @RequestParam String fromTo, Model model) {
        String result;
        if (fromTo.equals("1")){
            result = translateService.translateFromEnglish(word);
            model.addAttribute("result",result);
        }else {
            result = translateService.translateFromVietnamese(word);
            model.addAttribute("result",result);
        }

        return "input";
    }
}
