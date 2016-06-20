package com.springiscoming.model.promising;

import com.springiscoming.model.customer.Customer;

public class PromisingCustomer {

    private Customer customer;
    private Float averageVisitTime;
    private Integer visitsCount;
    private Integer directVisitsCount;
    private Integer purchasesCount;
    private Float purchasesSummaryCost;
    private Float factor;

    public PromisingCustomer(Customer customer, Float averageVisitTime, Integer visitsCount, Integer directVisitsCount, Integer purchasesCount, Float purchasesSummaryCost, Float factor) {
        this.customer = customer;
        this.averageVisitTime = averageVisitTime;
        this.visitsCount = visitsCount;
        this.directVisitsCount = directVisitsCount;
        this.purchasesCount = purchasesCount;
        this.purchasesSummaryCost = purchasesSummaryCost;
        this.factor = factor;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Float getAverageVisitTime() {
        return averageVisitTime;
    }

    public void setAverageVisitTime(Float averageVisitTime) {
        this.averageVisitTime = averageVisitTime;
    }

    public Integer getVisitsCount() {
        return visitsCount;
    }

    public void setVisitsCount(Integer visitsCount) {
        this.visitsCount = visitsCount;
    }

    public Integer getDirectVisitsCount() {
        return directVisitsCount;
    }

    public void setDirectVisitsCount(Integer directVisitsCount) {
        this.directVisitsCount = directVisitsCount;
    }

    public Integer getPurchasesCount() {
        return purchasesCount;
    }

    public void setPurchasesCount(Integer purchasesCount) {
        this.purchasesCount = purchasesCount;
    }

    public Float getPurchasesSummaryCost() {
        return purchasesSummaryCost;
    }

    public void setPurchasesSummaryCost(Float purchasesSummaryCost) {
        this.purchasesSummaryCost = purchasesSummaryCost;
    }

    public Float getFactor() {
        return factor;
    }

    public void setFactor(Float factor) {
        this.factor = factor;
    }

    @Override
    public String toString() {
        return "PromisingCustomer{" +
                "customer=" + customer +
                ", averageVisitTime=" + averageVisitTime +
                ", visitsCount=" + visitsCount +
                ", directVisitsCount=" + directVisitsCount +
                ", purchasesCount=" + purchasesCount +
                ", purchasesSummaryCost=" + purchasesSummaryCost +
                ", factor=" + factor +
                '}';
    }
}