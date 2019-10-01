package com.dacbank.basel.api;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class BaselRequest {

    @NotNull(message="Operation ID required")
    private long idOperation;
    @NotNull(message="Basel method required")
    private int method;
    @NotNull(message="Basel map required")
    private int map;
    @NotNull(message="Operation product required")
    private int operProduct;
    @NotNull(message="Operation amount required")
    private BigDecimal operAmount;
    @NotNull(message="Currency of the operation required")
    private String operAmountCurrency;
    @NotNull(message="Collaterals value required")
    private BigDecimal operCollateralValue;
    @NotNull(message="Collaterals currency required")
    private String operCollatCurrency;
    @NotNull(message="Mortgages guarantees value required")
    private BigDecimal operMortgageGuaranteesValue;
    @NotNull(message="Mortgages currency required")
    private String operMortgageGuarCurrency;
    @NotNull(message="LTV required")
    private BigDecimal operLtv;

    public BaselRequest(){}

    public long getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(long idOperation) {
        this.idOperation = idOperation;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public int getMap() {
        return map;
    }

    public void setMap(int map) {
        this.map = map;
    }

    public int getOperProduct() {
        return operProduct;
    }

    public void setOperProduct(int operProduct) {
        this.operProduct = operProduct;
    }

    public BigDecimal getOperAmount() {
        return operAmount;
    }

    public void setOperAmount(BigDecimal operAmount) {
        this.operAmount = operAmount;
    }

    public BigDecimal getOperCollateralValue() {
        return operCollateralValue;
    }

    public void setOperCollateralValue(BigDecimal operCollateralValue) {
        this.operCollateralValue = operCollateralValue;
    }

    public BigDecimal getOperMortgageGuaranteesValue() {
        return operMortgageGuaranteesValue;
    }

    public void setOperMortgageGuaranteesValue(BigDecimal operMortgageGuaranteesValue) {
        this.operMortgageGuaranteesValue = operMortgageGuaranteesValue;
    }

    public String getOperAmountCurrency() {
        return operAmountCurrency;
    }

    public void setOperAmountCurrency(String operAmountCurrency) {
        this.operAmountCurrency = operAmountCurrency;
    }

    public String getOperCollatCurrency() {
        return operCollatCurrency;
    }

    public void setOperCollatCurrency(String operCollatCurrency) {
        this.operCollatCurrency = operCollatCurrency;
    }

    public String getOperMortgageGuarCurrency() {
        return operMortgageGuarCurrency;
    }

    public void setOperMortgageGuarCurrency(String operMortgageGuarCurrency) {
        this.operMortgageGuarCurrency = operMortgageGuarCurrency;
    }

    public BigDecimal getOperLtv() {
        return operLtv;
    }

    public void setOperLtv(BigDecimal operLtv) {
        this.operLtv = operLtv;
    }

}
