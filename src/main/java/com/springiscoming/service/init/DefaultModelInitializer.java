package com.springiscoming.service.init;

import com.springiscoming.enums.Education;
import com.springiscoming.enums.Gender;
import com.springiscoming.model.Customer;
import com.springiscoming.model.Product;
import com.springiscoming.model.SiteEntry;
import com.springiscoming.repository.CustomerRepository;
import com.springiscoming.service.CustomerService;
import com.springiscoming.service.OrderService;
import com.springiscoming.service.ProductService;
import com.springiscoming.service.SiteEntryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Service
@Transactional
public class DefaultModelInitializer {

    @Inject
    private OrderService orderService;

    @Inject
    private ProductService productService;

    @Inject
    private CustomerService customerService;

    @Inject
    private SiteEntryService siteEntryService;

    @PostConstruct
    private void posConstruct() {

        this.initCustomers();
        this.initSiteEntries();

        Product product = new Product();
        product.setCode("code123");

        productService.save(product);
    }

    private void initCustomers() {

        customerService.save(new Customer(Gender.Male, "31-350", Education.Higher, "email1@gmail.com"));
        customerService.save(new Customer(Gender.Female, "22-222", Education.Higher, "email5@default.com"));
        customerService.save(new Customer(Gender.Male, "33-222", Education.Higher, "email3@gmail.com'"));
        customerService.save(new Customer(Gender.Female, "31-356", Education.Higher, "email4@default.com"));
        customerService.save(new Customer(Gender.Male, "31-312", Education.Higher, "winio94@gmail.com"));

    }

    private void initSiteEntries() {

        siteEntryService.save(new SiteEntry(true, 123, customerService.findOneById(1L)));
        siteEntryService.save(new SiteEntry(true, 12, customerService.findOneById(2L)));
        siteEntryService.save(new SiteEntry(false, 3, customerService.findOneById(3L)));
        siteEntryService.save(new SiteEntry(true, 100, customerService.findOneById(2L)));
        siteEntryService.save(new SiteEntry(true, 500, customerService.findOneById(4L)));
        siteEntryService.save(new SiteEntry(true, 60, customerService.findOneById(3L)));
        siteEntryService.save(new SiteEntry(true, 4, customerService.findOneById(2L)));

    }
}
