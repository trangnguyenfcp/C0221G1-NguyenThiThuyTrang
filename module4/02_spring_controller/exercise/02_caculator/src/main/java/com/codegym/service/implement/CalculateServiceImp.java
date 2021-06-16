package com.codegym.service.implement;

import com.codegym.service.CalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImp implements CalculateService {
    @Override
    public String calculate(int num1, int num2, String sign) {
        String result = "Input is invalid";
        switch (sign){
            case "+":
                result = String.valueOf(num1 + num2);
                break;
            case "-":
                result = String.valueOf(num1 - num2);
                break;
            case "X":
                result = String.valueOf(num1 * num2);
                break;
            case "/":
                double res = (double)num1 / num2;
                result = String.valueOf(Math.round(res*100)/100D);
                break;
        }
        return result;
    }
}
