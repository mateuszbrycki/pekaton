package com.springiscoming.service.builders;

import com.springiscoming.model.Customer;

/**
 * Created by winio_000 on 2016-06-19.
 */
public class CustomerBuilder {

    private Long customerId;

    private CustomerBuilder() {
    }

    public static CustomerBuilder get() {
        return new CustomerBuilder();
    }

    public CustomerBuilder withCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public Customer build() {
        Customer customer = new Customer();

        customer.setCustomerId(customerId);

        return customer;
    }
}
