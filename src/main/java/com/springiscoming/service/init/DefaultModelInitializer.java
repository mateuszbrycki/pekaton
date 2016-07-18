package com.springiscoming.service.init;

import com.springiscoming.enums.Delivery;
import com.springiscoming.enums.Education;
import com.springiscoming.enums.Gender;
import com.springiscoming.model.entity.Customer;
import com.springiscoming.model.entity.Product;
import com.springiscoming.model.entity.Purchase;
import com.springiscoming.model.entity.SiteEntry;
import com.springiscoming.service.CustomerService;
import com.springiscoming.service.ProductService;
import com.springiscoming.service.PurchaseService;
import com.springiscoming.service.SiteEntryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;
import java.util.Random;

import static com.springiscoming.util.DateUtils.generateRandomDate;

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

    @Inject
    private PostalCodePovider postalCodePovider;

    @PostConstruct
    private void posConstruct() {
        initCustomers(33);
        initPurchases();
        initSiteEntries(100);
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
                generateRandomDate(),
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

    private void initCustomers(int count) {
        initializeRundomCustomers(count);
    }

    private void initializeRundomCustomers(int count) {
        for (int i = 0; i < count; i++) {
            customerService.save(new Customer(randomGender(), randomPostCode(), randomEducation(), randomEmail()));
        }
    }

    private String randomEmail() {
        Random random = new Random();
        return "email" + random.nextInt(100) + "@gmail.com";
    }

    private Education randomEducation() {
        Education[] values = Education.values();
        return values[randomInt(values.length)];
    }

    private String randomPostCode() {
        List<String> codes = postalCodePovider.postalCodes();
        return codes.get(new Random().nextInt(codes.size() - 1));
    }

    private int randomInt(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    private Gender randomGender() {
        Gender[] values = Gender.values();
        return values[randomInt(values.length)];
    }

    private void initSiteEntries(int siteEntriesAmmount) {
        Random random = new Random();
        int customerAmmount = customerService.findAll().size();
        for (int i = 0; i < siteEntriesAmmount; i++) {
            siteEntryService.save(new SiteEntry(
                    random.nextBoolean(),
                    random.nextInt(1000),
                    customerService.findOneById(randomIdFromRange(0, customerAmmount, random)),
                    generateRandomDate()
            ));
        }
    }

    private Long randomIdFromRange(int start, int end, Random random) {
        long randomLong = (long) (random.nextInt((end - start)) + start);
        return randomLong > 0 && randomLong < end ? randomLong : 1;
    }
}