package com.springiscoming.model.promising;

import com.springiscoming.model.Customer;

public class PromisingCustomer {

    private Customer customer;
    private Float factor;

    private Float averageVisitTime;
    private Integer visitsCount;
    private Integer directVisitsCount;

    private Integer purchasesCount;
    private Float purchasesSummaryCost;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Float getFactor() {
        return factor;
    }

    public void setFactor(Float promisingFactor) {
        this.factor = promisingFactor;
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

    @Override
    public String toString() {
        return "PromisingCustomer{" +
                "customer=" + customer +
                ", factor=" + factor +
                ", averageVisitTime=" + averageVisitTime +
                ", visitsCount=" + visitsCount +
                ", directVisitsCount=" + directVisitsCount +
                ", purchasesCount=" + purchasesCount +
                ", purchasesSummaryCost=" + purchasesSummaryCost +
                '}';
    }
}
