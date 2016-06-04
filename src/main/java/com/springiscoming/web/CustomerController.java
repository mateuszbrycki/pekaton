package com.springiscoming.web;

import com.springiscoming.model.promising.PromisingCustomer;
import com.springiscoming.service.primising.PromisingCustomersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Inject
    private PromisingCustomersService promisingCustomersService;


    @RequestMapping(path = "/promising", method = RequestMethod.GET)
    public List<PromisingCustomer> findPromisingCustomers() {
        return promisingCustomersService.findPromisingCustomersList();
    }

}
