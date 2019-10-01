package com.dacbank.currencyconversor.service;

import com.dacbank.currencyconversor.dto.CC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CCService {

    @Autowired
    private Environment environment;
    public CCService(Environment environment){
        this.environment = environment;
    }

    public CC convertCurrency(String from, String to, BigDecimal quantity){
        // temporary constant conversion
        final BigDecimal constantMultiple = new BigDecimal(1.50);

        CC cc = new CC(1, from, to, quantity, constantMultiple, quantity.multiply(constantMultiple),
                Integer.parseInt(environment.getProperty("local.server.port")));

        return cc;
    }
}
