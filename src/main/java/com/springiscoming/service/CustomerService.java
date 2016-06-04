package com.springiscoming.service;

import com.springiscoming.model.Customer;
import com.springiscoming.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Service
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;

    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    public Customer findOneById(Long customerId) {
        return this.customerRepository.findOneByCustomerId(customerId);
    }

}
