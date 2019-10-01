package com.dacbank.basel.service;

import com.dacbank.basel.api.CCResponse;
import com.dacbank.basel.dao.BaselRepository;
import com.dacbank.basel.dto.Basel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BaselService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // Basel risk categories
    private final Integer category_CPF01 = 101; // mortgages
    private final Integer category_CPF02 = 102; // personal loans
    private final Integer category_CPF03 = 103; // credit cards
    private final Integer category_CPF04 = 104; // overdrafts
    private final Integer category_CPF05 = 105; // other operations
    private final Integer category_CPF06 = 106; // big operations
    private final Integer category_CPF07 = 107; // consumer finance - cards
    private final Integer category_CPF09 = 123; // consumer finance - loans
    private final Integer category_CPF11 = 109; // second mortgages

    // Basel categories criteria
    private final BigDecimal max_amount_PF01 = new BigDecimal(600000.00);
    private final BigDecimal max_ltv_PF01 = new BigDecimal(100.00);
    private final BigDecimal max_amount_PF02 = new BigDecimal(90000.00);
    private final BigDecimal max_amount_PF03 = new BigDecimal(600000.00);
    private final BigDecimal max_amount_PF04 = new BigDecimal(90000.00);
    private final BigDecimal min_amount_PF06 = new BigDecimal(600000.00);
    private final BigDecimal max_ltv_PF06 = new BigDecimal(100.00);
    private final BigDecimal min_mortgages_guarantees_PF06 = new BigDecimal(0.00);
    private final BigDecimal max_amount_PF11 = new BigDecimal(600000.00);
    private final BigDecimal max_ltv_PF11 = new BigDecimal(100.00);

    // Product types (operProduct, productType, cfProduct)
    private static Map<Integer, ProductsTuple> productInfo;
    static {
        productInfo = new HashMap<>();
        productInfo.put(1000, new ProductsTuple("CARDS", false));
        productInfo.put(1001, new ProductsTuple("CARDS", true));
        productInfo.put(2000, new ProductsTuple("OVERDRAFTS", false));
        productInfo.put(3000, new ProductsTuple("MORTGAGES", false));
        productInfo.put(4000, new ProductsTuple("HOME_EQUITY", false));
        productInfo.put(5000, new ProductsTuple("OPEN_MARKET", false));
        productInfo.put(6000, new ProductsTuple("CPCL", false));
    }

    @Autowired
    BaselRepository baselRepository;
    @Autowired
    CurrencyConversionServiceProxy proxy;
    public BaselService(BaselRepository baselRepository, CurrencyConversionServiceProxy proxy){
        this.baselRepository = baselRepository;
        this.proxy = proxy;
    }

    public Basel newAnalysis(Basel basel){
        basel.settimestampAnalysis(new Timestamp(System.currentTimeMillis()));
        return save(basel);
    }

    public Basel getAnalysis(long id_analysis) throws NotFoundException{
        Optional<Basel> basel = baselRepository.findById(id_analysis);
        basel.orElseThrow(NotFoundException::new);
        return basel.get();
    }

    public List<Basel> getAllAnalyzes(){
        return baselRepository.findAll();
    }

    public List<Basel> getAllAnalyzesPaginated(int page, int size) throws NotFoundException{
        Pageable pageRequested = PageRequest.of(page, size);
        return baselRepository.findAll(pageRequested).getContent();
    }

    private Basel save(Basel basel){
        return baselRepository.saveAndFlush(basel);
    }

    public Basel baselAnalysis(Basel basel){
        //get product info (product type & Consumer Finance indicator)
        getProductInfo(basel);

        //convert quantities to Euro currency
        counterCurrency(basel);

        //obtain operation category
        categorizeOperation(basel);

        //obtain operation probability of default
        setPD(basel);

        return basel;
    }

    private Basel getProductInfo(Basel basel){
        basel.setproductType(productInfo.get(basel.getoperProduct()).getProductType());
        basel.setcfProduct(productInfo.get(basel.getoperProduct()).getConsumerFinance());
        return basel;
    }

    private Basel counterCurrency(Basel basel){

        if(basel.getOperAmountCurrency().equalsIgnoreCase("EUR")){
            basel.setOperAmountInEuros(basel.getoperAmount());
        } else {
            basel.setOperAmountInEuros(
                    callCurrencyConversor(basel)
                            .getQuantityConverted()
            );
        }

        if(basel.getOperCollatCurrency().equalsIgnoreCase("EUR")){
            basel.setOperCollatInEuros(basel.getoperCollateralValue());
        } else {
            basel.setOperAmountInEuros(
                    callCurrencyConversor(basel)
                            .getQuantityConverted()
            );
        }

        if(basel.getOperMortgageGuarCurrency().equalsIgnoreCase("EUR")){
            basel.setOperMortgageGuarInEuros(basel.getoperMortgageGuaranteesValue());
        } else {
            basel.setOperAmountInEuros(
                    callCurrencyConversor(basel)
                            .getQuantityConverted()
            );
        }

        return basel;
    }

    private CCResponse callCurrencyConversor(Basel basel){
        String portList = "";

        CCResponse response = proxy.convertCurrency(basel.getOperAmountCurrency(), "EUR", basel.getoperAmount());
        logger.info("{}", response);

        portList=(basel.getPort() == null? "" : basel.getPort() + " ") + response.getPort();
        basel.setPort(portList);

        return response;
    }

    private Basel categorizeOperation(Basel basel){
        //default category: CPF05
        Integer category = category_CPF05;

        if(basel.getproductType().equalsIgnoreCase("MORTGAGES") &&
                basel.getoperAmount().compareTo(max_amount_PF01) <= 0 &&
                basel.getoperLtv().compareTo(max_ltv_PF01) < 0){
            category = category_CPF01;
        }

        if((basel.getproductType().equalsIgnoreCase("OPEN_MARKET") ||
                basel.getproductType().equalsIgnoreCase("CPCL")) &&
                basel.getoperAmount().compareTo(max_amount_PF02) < 0 &&
                basel.getoperCollateralValue().compareTo(new BigDecimal(0)) == 0  &&
                basel.getoperMortgageGuaranteesValue().compareTo(new BigDecimal(0)) == 0){
            category = category_CPF02;
        }

        if(basel.getproductType().equalsIgnoreCase("CARDS") &&
                basel.getoperAmount().compareTo(max_amount_PF03) < 0){
            category = category_CPF03;
        }

        if(basel.getproductType().equalsIgnoreCase("OVERDRAFTS") &&
                basel.getoperAmount().compareTo(max_amount_PF04) < 0){
            category = category_CPF04;
        }

        if((basel.getproductType().equalsIgnoreCase("MORTGAGES") ||
                basel.getproductType().equalsIgnoreCase("HOME_EQUITY")) &&
                basel.getoperAmount().compareTo(min_amount_PF06) > 0 &&
                basel.getoperLtv().compareTo(max_ltv_PF06) < 0 &&
                basel.getoperMortgageGuaranteesValue().compareTo(min_mortgages_guarantees_PF06) > 0){
            category = category_CPF06;
        }

        if(basel.getcfProduct()){
            if(basel.getproductType().equalsIgnoreCase("CARDS")){
                category = category_CPF07;
            }else{
                category = category_CPF09;
            }
        }

        if(basel.getproductType().equalsIgnoreCase("HOME_EQUITY") &&
                basel.getoperAmount().compareTo(max_amount_PF11) <= 0 &&
                basel.getoperLtv().compareTo(max_ltv_PF11) < 0){
            category = category_CPF11;
        }

        basel.setseqBaselCategory(category);
        return basel;
    }

    private Basel setPD(Basel basel){
        //<temporal> constant seq cateory & final node
        final BigDecimal PD = new BigDecimal(65.25);
        final int final_nod = 112121000;
        //<temporal>

        basel.setPd(PD);
        basel.setfinalNode(final_nod);
        return basel;
    }

}

class ProductsTuple{
    private String productType;
    private boolean consumerFinance;

    public ProductsTuple(String productType, boolean consumerFinance){
        this.productType = productType;
        this.consumerFinance = consumerFinance;
    }

    public String getProductType(){ return this.productType; }
    public boolean getConsumerFinance(){ return this.consumerFinance; }
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException extends RuntimeException {}
