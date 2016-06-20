package com.springiscoming.service.promising;

import com.springiscoming.model.customer.Customer;
import com.springiscoming.model.promising.PromisingCustomer;
import com.springiscoming.service.customer.CustomerService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz on 04.06.2016.
 */
@Service
public class PromisingCustomersService {

    @Inject
    private CustomerService customerService;

    @Inject
    private PromisingCustomerProvider promisingCustomerProvider;

    public List<PromisingCustomer> findPromisingCustomers() {
        return promisingCustomers(customerService.findAll());
    }

    private List<PromisingCustomer> promisingCustomers(List<Customer> customers) {
        List<PromisingCustomer> result = new ArrayList<>();
        for (Customer customer : customers) {
            PromisingCustomer promisingCustomer = promisingCustomerProvider.get(customer);

            if (isPositive(promisingCustomer.getFactor())) {
                result.add(promisingCustomer);
            }
        }

        return result;
    }

    private boolean isPositive(Float promisingCustomerFactor) {
        return promisingCustomerFactor != null && promisingCustomerFactor > 0;
    }
}