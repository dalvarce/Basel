package com.dacbank.basel.api;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class BaselResponse {

    private long idAnalysis;
    private Timestamp timestampAnalysis;
    private long idOperation;
    private int method;
    private int map;
    private int operProduct;
    private BigDecimal operAmount;
    private String operAmountCurrency;
    private BigDecimal operAmountInEuros;
    private BigDecimal operCollateralValue;
    private String operCollatCurrency;
    private BigDecimal operCollatInEuros;
    private BigDecimal operMortgageGuaranteesValue;
    private String operMortgageGuarCurrency;
    private BigDecimal operMortgageGuarInEuros;
    private BigDecimal operLtv;
    private int seqBaselCategory;
    private int finalNode;
    private BigDecimal pd;
    private String productType;
    private boolean cfProduct;
    private String port;

    public BaselResponse(){}

    public long getIdAnalysis() {
        return idAnalysis;
    }

    public void setIdAnalysis(long idAnalysis) {
        this.idAnalysis = idAnalysis;
    }

    public Timestamp getTimestampAnalysis() {
        return timestampAnalysis;
    }

    public void setTimestampAnalysis(Timestamp timestampAnalysis) {
        this.timestampAnalysis = timestampAnalysis;
    }

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

    public BigDecimal getOperAmountInEuros() {
        return operAmountInEuros;
    }

    public void setOperAmountInEuros(BigDecimal operAmountInEuros) {
        this.operAmountInEuros = operAmountInEuros;
    }

    public String getOperCollatCurrency() {
        return operCollatCurrency;
    }

    public void setOperCollatCurrency(String operCollatCurrency) {
        this.operCollatCurrency = operCollatCurrency;
    }

    public BigDecimal getOperCollatInEuros() {
        return operCollatInEuros;
    }

    public void setOperCollatInEuros(BigDecimal operCollatInEuros) {
        this.operCollatInEuros = operCollatInEuros;
    }

    public String getOperMortgageGuarCurrency() {
        return operMortgageGuarCurrency;
    }

    public void setOperMortgageGuarCurrency(String operMortgageGuarCurrency) {
        this.operMortgageGuarCurrency = operMortgageGuarCurrency;
    }

    public BigDecimal getOperMortgageGuarInEuros() {
        return operMortgageGuarInEuros;
    }

    public void setOperMortgageGuarInEuros(BigDecimal operMortgageGuarInEuros) {
        this.operMortgageGuarInEuros = operMortgageGuarInEuros;
    }

    public BigDecimal getOperLtv() {
        return operLtv;
    }

    public void setOperLtv(BigDecimal operLtv) {
        this.operLtv = operLtv;
    }

    public int getSeqBaselCategory() {
        return seqBaselCategory;
    }

    public void setSeqBaselCategory(int seqBaselCategory) {
        this.seqBaselCategory = seqBaselCategory;
    }

    public int getFinalNode() {
        return finalNode;
    }

    public void setFinalNode(int finalNode) {
        this.finalNode = finalNode;
    }

    public BigDecimal getPd() {
        return pd;
    }

    public void setPd(BigDecimal pd) {
        this.pd = pd;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public boolean getCfProduct() {
        return cfProduct;
    }

    public void setCfProduct(boolean cfProduct) {
        this.cfProduct = cfProduct;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
