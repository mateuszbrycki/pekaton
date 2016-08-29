package com.springiscoming.service;

import com.springiscoming.model.entity.Customer;
import com.springiscoming.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

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

    public List<Customer> findAll() {return this.customerRepository.findAll(); }

}
