package com.dacbank.basel.service;


import com.dacbank.basel.api.CCResponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name="currency-conversor-service")
@RibbonClient(name="currency-conversor-service")
public interface CurrencyConversionServiceProxy {
    @GetMapping(value="/currencyconversor/v1/conversions", params= {"from", "to", "quantity"})
    public CCResponse convertCurrency
            (@RequestParam("from") String from,
             @RequestParam("to") String to,
             @RequestParam("quantity") BigDecimal quantity);
}