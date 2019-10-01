package com.dacbank.basel.dto;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Basel implements Serializable {
    private static final long serialVersionUID = 6297729030347835498L;

    @Id
    @GeneratedValue
    long idAnalysis;
    Timestamp timestampAnalysis;
    long idOperation;
    int method;
    int map;
    int operProduct;
    BigDecimal operAmount;
    String operAmountCurrency;
    BigDecimal operAmountInEuros;
    BigDecimal operCollateralValue;
    String operCollatCurrency;
    BigDecimal operCollatInEuros;
    BigDecimal operMortgageGuaranteesValue;
    String operMortgageGuarCurrency;
    BigDecimal operMortgageGuarInEuros;
    BigDecimal operLtv;
    int seqBaselCategory;
    int finalNode;
    BigDecimal pd;
    String productType;
    boolean cfProduct;
    String port;

    public Basel(long idAnalysis, Timestamp timestampAnalysis, long idOperation, int method, int map, int operProduct, BigDecimal operAmount, String operAmountCurrency, BigDecimal operAmountInEuros, BigDecimal operCollateralValue, String operCollatCurrency, BigDecimal operCollatInEuros, BigDecimal operMortgageGuaranteesValue, String operMortgageGuarCurrency, BigDecimal operMortgageGuarInEuros, BigDecimal operLtv, int seqBaselCategory, int finalNode, BigDecimal pd, String productType, boolean cfProduct, String port) {
        this.idAnalysis = idAnalysis;
        this.timestampAnalysis = timestampAnalysis;
        this.idOperation = idOperation;
        this.method = method;
        this.map = map;
        this.operProduct = operProduct;
        this.operAmount = operAmount;
        this.operAmountCurrency = operAmountCurrency;
        this.operAmountInEuros = operAmountInEuros;
        this.operCollateralValue = operCollateralValue;
        this.operCollatCurrency = operCollatCurrency;
        this.operCollatInEuros = operCollatInEuros;
        this.operMortgageGuaranteesValue = operMortgageGuaranteesValue;
        this.operMortgageGuarCurrency = operMortgageGuarCurrency;
        this.operMortgageGuarInEuros = operMortgageGuarInEuros;
        this.operLtv = operLtv;
        this.seqBaselCategory = seqBaselCategory;
        this.finalNode = finalNode;
        this.pd = pd;
        this.productType = productType;
        this.cfProduct = cfProduct;
        this.port = port;
    }

    public Basel(){}

    @Override
    public String toString() {
        return "Basel{" +
                "idAnalysis=" + idAnalysis +
                ", timestampAnalysis=" + timestampAnalysis +
                ", idOperation=" + idOperation +
                ", method=" + method +
                ", map=" + map +
                ", operProduct=" + operProduct +
                ", operAmount=" + operAmount +
                ", operAmountCurrency='" + operAmountCurrency + '\'' +
                ", operAmountInEuros=" + operAmountInEuros +
                ", operCollateralValue=" + operCollateralValue +
                ", operCollatCurrency='" + operCollatCurrency + '\'' +
                ", operCollatInEuros=" + operCollatInEuros +
                ", operMortgageGuaranteesValue=" + operMortgageGuaranteesValue +
                ", operMortgageGuarCurrency='" + operMortgageGuarCurrency + '\'' +
                ", operMortgageGuarInEuros=" + operMortgageGuarInEuros +
                ", operLtv=" + operLtv +
                ", seqBaselCategory=" + seqBaselCategory +
                ", finalNode=" + finalNode +
                ", pd=" + pd +
                ", productType='" + productType + '\'' +
                ", cfProduct=" + cfProduct +
                ", port=" + port +
                '}';
    }

    public void setidAnalysis(long idAnalysis) {
        this.idAnalysis = idAnalysis;
    }

    public void settimestampAnalysis(Timestamp timestampAnalysis) {
        this.timestampAnalysis = timestampAnalysis;
    }

    public void setidOperation(long idOperation) {
        this.idOperation = idOperation;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public void setMap(int map) {
        this.map = map;
    }

    public void setoperProduct(int operProduct) {
        this.operProduct = operProduct;
    }

    public void setoperAmount(BigDecimal operAmount) {
        this.operAmount = operAmount;
    }

    public void setoperCollateralValue(BigDecimal operCollateralValue) {
        this.operCollateralValue = operCollateralValue;
    }

    public void setoperMortgageGuaranteesValue(BigDecimal operMortgageGuaranteesValue) {
        this.operMortgageGuaranteesValue = operMortgageGuaranteesValue;
    }

    public void setoperLtv(BigDecimal operLtv) {
        this.operLtv = operLtv;
    }

    public void setseqBaselCategory(int seqBaselCategory) {
        this.seqBaselCategory = seqBaselCategory;
    }

    public void setfinalNode(int finalNode) {
        this.finalNode = finalNode;
    }

    public void setPd(BigDecimal pd) {
        this.pd = pd;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Timestamp gettimestampAnalysis() {
        return timestampAnalysis;
    }

    public long getidAnalysis() {
        return idAnalysis;
    }

    public long getidOperation() {
        return idOperation;
    }

    public int getMethod() {
        return method;
    }

    public int getMap() {
        return map;
    }

    public int getoperProduct() {
        return operProduct;
    }

    public BigDecimal getoperAmount() {
        return operAmount;
    }

    public BigDecimal getoperCollateralValue() {
        return operCollateralValue;
    }

    public BigDecimal getoperMortgageGuaranteesValue() {
        return operMortgageGuaranteesValue;
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

    public BigDecimal getoperLtv() {
        return operLtv;
    }

    public int getseqBaselCategory() {
        return seqBaselCategory;
    }

    public int getfinalNode() {
        return finalNode;
    }

    public BigDecimal getPd() {
        return pd;
    }

    public String getproductType() { return (productType==null ? "" : productType); }

    public void setproductType(String productType) {
        this.productType = productType;
    }

    public boolean getcfProduct() {
        return cfProduct;
    }

    public void setcfProduct(boolean cfProduct) {
        this.cfProduct = cfProduct;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
