package com.springiscoming.web;

import com.springiscoming.model.Customer;
import com.springiscoming.model.promising.PromisingCustomer;
import com.springiscoming.service.CustomerService;
import com.springiscoming.service.primising.PromisingCustomersService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Inject
    private PromisingCustomersService promisingCustomersService;

    @Inject
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> findAllCustomers() {
        return customerService.findAll();
    }

    @RequestMapping(path = "/promising", method = RequestMethod.GET)
    public List<PromisingCustomer> findPromisingCustomers() {
        return promisingCustomersService.findPromisingCustomersList();
    }

}
