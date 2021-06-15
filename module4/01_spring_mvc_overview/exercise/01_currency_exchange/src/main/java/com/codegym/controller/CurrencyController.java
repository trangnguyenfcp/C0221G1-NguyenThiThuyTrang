package com.codegym.controller;

import com.codegym.service.ExchangeService;
import com.codegym.service.implement.ExchangeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static javax.print.attribute.standard.MediaSizeName.D;

@Controller
public class CurrencyController {
    public static Map<String, String> currencies = new HashMap<String, String>();
    static {
        currencies.put("Viet Nam", "1");
        currencies.put("Dollar (USD)", "22800");
        currencies.put("Pound (GBD)", "32200");
    }
   @Autowired
    private ExchangeService exchangeService;
    @GetMapping(value = {"/"})
    public String input(Model model) {
        model.addAttribute("currencies",currencies);
        return "input";
    }

    @PostMapping(value = {"/exchange"})
    public String currencyExchange(@RequestParam String amount,
                                   @RequestParam String from,
                                   @RequestParam String to, Model model) {
        int amountMoney = Integer.parseInt(amount);
        int fromCurrency = Integer.parseInt(from);
        int toCurrency = Integer.parseInt(to);
        double result=exchangeService.exchangeCurrency(amountMoney,fromCurrency,toCurrency);
        model.addAttribute("currencies",currencies);
        model.addAttribute("amount", amountMoney);
        model.addAttribute("from", fromCurrency);
        model.addAttribute("to", toCurrency);
        model.addAttribute("result", result);
        return "result";
    }
}
