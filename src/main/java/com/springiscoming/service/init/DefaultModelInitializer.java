package com.springiscoming.service.init;

import com.springiscoming.enums.Delivery;
import com.springiscoming.enums.Education;
import com.springiscoming.enums.Gender;
import com.springiscoming.model.Customer;
import com.springiscoming.model.Product;
import com.springiscoming.model.Purchase;
import com.springiscoming.model.SiteEntry;
import com.springiscoming.service.CustomerService;
import com.springiscoming.service.ProductService;
import com.springiscoming.service.PurchaseService;
import com.springiscoming.service.SiteEntryService;
import com.springiscoming.util.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Service
@Transactional
public class DefaultModelInitializer {

    @Inject
    private PurchaseService purchaseService;

    @Inject
    private ProductService productService;

    @Inject
    private CustomerService customerService;

    @Inject
    private SiteEntryService siteEntryService;

    @PostConstruct
    private void posConstruct() {
        initCustomers();
        initPurchases();
        initSiteEntries();
        initProducts();
    }

    private void initPurchases() {

        purchaseService.savePurchase(order(1L));
        purchaseService.savePurchase(order(2L));
        purchaseService.savePurchase(order(2L));
        purchaseService.savePurchase(order(3L));
        purchaseService.savePurchase(order(4L));
        purchaseService.savePurchase(order(5L));
        purchaseService.savePurchase(order(6L));
        purchaseService.savePurchase(order(7L));
        purchaseService.savePurchase(order(8L));
        purchaseService.savePurchase(order(9L));
        purchaseService.savePurchase(order(10L));
    }

    private Purchase order(long customerId) {
        return new Purchase(productService.getAll(),
                DateUtils.generateRandomDate(),
                customerService.findOneById(customerId),
                new Random().nextDouble() * 100,
                Delivery.Courier);
    }

    private void initProducts() {
        productService.save(new Product("code1", purchaseService.findPurchaseById(1L), 11.99F, "product1"));
        productService.save(new Product("code1", purchaseService.findPurchaseById(2L), 11.99F, "product1"));
        productService.save(new Product("code1", purchaseService.findPurchaseById(3L), 11.99F, "product1"));
        productService.save(new Product("code1", purchaseService.findPurchaseById(3L), 11.99F, "product1"));
        productService.save(new Product("code2", purchaseService.findPurchaseById(1L), 11.99F, "product2"));
        productService.save(new Product("code2", purchaseService.findPurchaseById(2L), 11.99F, "product2"));
        productService.save(new Product("code3", purchaseService.findPurchaseById(3L), 11.99F, "product3"));
        productService.save(new Product("code3", purchaseService.findPurchaseById(4L), 11.99F, "product3"));
        productService.save(new Product("code3", purchaseService.findPurchaseById(1L), 11.99F, "product3"));
        productService.save(new Product("code4", purchaseService.findPurchaseById(1L), 11.99F, "product4"));

    }

    private void initCustomers() {

        customerService.save(new Customer(Gender.Male, "31-350", Education.Higher, "email1@gmail.com"));
        customerService.save(new Customer(Gender.Female, "22-222", Education.Higher, "email5@default.com"));
        customerService.save(new Customer(Gender.Male, "33-222", Education.Higher, "email3@gmail.com"));
        customerService.save(new Customer(Gender.Female, "31-356", Education.Higher, "email4@default.com"));
        customerService.save(new Customer(Gender.Male, "31-312", Education.Higher, "winio94@gmail.com"));

    }

    private void initSiteEntries() {

        siteEntryService.save(new SiteEntry(true, 180, customerService.findOneById(1L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 180, customerService.findOneById(1L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 180, customerService.findOneById(1L), DateUtils.generateRandomDate()));

        siteEntryService.save(new SiteEntry(true, 180, customerService.findOneById(2L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 100, customerService.findOneById(2L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 15, customerService.findOneById(2L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 10, customerService.findOneById(2L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 8, customerService.findOneById(2L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 4, customerService.findOneById(2L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 15, customerService.findOneById(2L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 58, customerService.findOneById(2L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 60, customerService.findOneById(2L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 100, customerService.findOneById(2L), DateUtils.generateRandomDate()));

        siteEntryService.save(new SiteEntry(true, 200, customerService.findOneById(3L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(true, 180, customerService.findOneById(3L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(true, 300, customerService.findOneById(3L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(true, 20, customerService.findOneById(3L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(true, 15, customerService.findOneById(3L), DateUtils.generateRandomDate()));

        siteEntryService.save(new SiteEntry(true, 400, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 300, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 10, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 60, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 10, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 16, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 78, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 98, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 400, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 900, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 37, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 60, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 78, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 500, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 550, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 600, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 14, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 89, customerService.findOneById(4L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 10, customerService.findOneById(4L), DateUtils.generateRandomDate()));

        siteEntryService.save(new SiteEntry(true, 15, customerService.findOneById(5L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(true, 69, customerService.findOneById(5L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 300, customerService.findOneById(5L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 900, customerService.findOneById(5L), DateUtils.generateRandomDate()));
        siteEntryService.save(new SiteEntry(false, 10, customerService.findOneById(5L), DateUtils.generateRandomDate()));
    }
    
}
