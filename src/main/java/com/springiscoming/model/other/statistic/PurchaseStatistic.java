package com.springiscoming.model.other.statistic;

import java.util.Date;

/**
 * Created by winio_000 on 2016-06-04.
 */

public class PurchaseStatistic {

    private String purchaseDate;
    private Integer counter;
    private Integer productCounter;
    private Double value;

    public PurchaseStatistic(String purchaseDate, Integer counter, Integer productCounter, Double value) {
        this.purchaseDate = purchaseDate;
        this.counter = counter;
        this.productCounter = productCounter;
        this.value = value;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Integer getProductCounter() {
        return productCounter;
    }

    public void setProductCounter(Integer productCounter) {
        this.productCounter = productCounter;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }


}
