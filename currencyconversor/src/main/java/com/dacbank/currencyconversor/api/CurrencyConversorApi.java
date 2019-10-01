package com.dacbank.currencyconversor.api;

import com.dacbank.currencyconversor.dto.CC;
import com.dacbank.currencyconversor.service.CCService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/currencyconversor/v1/conversions", produces = "application/hal+json")
public class CurrencyConversorApi {

    @Autowired
    private CCService ccService;
    @Autowired
    private ModelMapper modelMapper;
    public CurrencyConversorApi(CCService ccService, ModelMapper modelMapper){
        this.ccService = ccService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value="", params={"from", "to", "quantity"})
    public CCResponse convertCurrency(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("quantity") BigDecimal quantity) {

        CCResponse ccResponse = convertToBaselResponseDTO(ccService.convertCurrency(from, to, quantity));
        return ccResponse;
    }

    /**
     * ****************************************************************
     * < Mapping methods >
     */

    private CC convertToCCEntity(CCRequest ccRequest){
        CC cc = modelMapper.map(ccRequest, CC.class);
        return cc;
    }

    private CCResponse convertToBaselResponseDTO(CC cc){
        CCResponse ccResponse = modelMapper.map(cc, CCResponse.class);
        return ccResponse;
    }

}
