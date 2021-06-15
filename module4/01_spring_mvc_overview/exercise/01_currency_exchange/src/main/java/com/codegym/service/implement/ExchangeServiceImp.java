package com.codegym.service.implement;

import com.codegym.service.ExchangeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class ExchangeServiceImp implements ExchangeService {

    @Override
    public double exchangeCurrency(int amount, int from, int to) {
        double result1 = (double)(amount*from)/to;
        double result = Math.round(result1*100)/100D;
        return result;
    }
}
