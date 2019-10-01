package com.dacbank.currencyconversor.api;

import java.math.BigDecimal;

public class CCResponse {

    private long id;
    private String from;
    private String to;
    private BigDecimal quantity;
    private int port;
    private BigDecimal conversionMultiple;
    private BigDecimal quantityConverted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public BigDecimal getQuantityConverted() {
        return quantityConverted;
    }

    public void setQuantityConverted(BigDecimal quantityConverted) {
        this.quantityConverted = quantityConverted;
    }
}
