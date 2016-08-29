package com.springiscoming.web;

import com.springiscoming.enums.Gender;
import com.springiscoming.model.entity.Customer;
import com.springiscoming.model.other.promising.PromisingCustomer;
import com.springiscoming.service.CustomerService;
import com.springiscoming.service.promising.PromisingCustomersService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.HashMap;
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

    @RequestMapping(path = "/statistics", method = RequestMethod.GET)
    public HashMap<Gender, Integer> getGenderStatistics() {
        List<Customer> allCustomers = customerService.findAll();
        HashMap<Gender, Integer> genderCounters = new HashMap<>();
        int femalesCounter = 0;
        for (Customer customer : allCustomers) {
            if (customer.getGender().equals(Gender.Female)) {
                genderCounters.put(Gender.Female, ++femalesCounter);
            }
        }
        genderCounters.put(Gender.Male, allCustomers.size() - genderCounters.get(Gender.Female));
        return genderCounters;
    }
}
