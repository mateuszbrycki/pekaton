package com.springiscoming.model.promising;

import com.springiscoming.model.Customer;

public class PromisingCustomer {

    private Customer customer;
    private Float factor;

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

    @Override
    public String toString() {
        return "PromisingCustomer{" +
                "customer=" + customer +
                ", factor=" + factor +
                '}';
    }
}
