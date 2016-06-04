package com.springiscoming.model;

/**
 * Created by winio_000 on 2016-06-04.
 */

public class PurchaseStatistic {

    private String purchaseDate;
    private Integer counter;

    public PurchaseStatistic(String purchaseDate, Integer counter) {
        this.purchaseDate = purchaseDate;
        this.counter = counter;
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
}
