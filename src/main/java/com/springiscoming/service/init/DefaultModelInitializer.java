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

    private static final int CUSTOMER_AMMOUNT = 33;
    public static final int SITE_ENTRIES_AMMOUNT = 100;
    private static final int PURCHASE_AMMOUNT = 80;

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
    public void posConstruct() {
        initCustomers();
        initPurchases();
        initSiteEntries();
        initProducts();
    }

    public void initCustomers() {
        for (int i = 0; i < CUSTOMER_AMMOUNT; i++) {
            customerService.save(new Customer(randomGender(), randomPostCode(), randomEducation(), randomEmail()));
        }
    }

    public void initPurchases() {
        Random random = new Random();
        int customerAmmount = customerService.findAll().size();

        for (int i = 0; i < PURCHASE_AMMOUNT; i++) {
            Purchase purchase = new Purchase(
                    productService.getAll(),
                    generateRandomDate(),
                    customerService.findOneById(randomIdFromRange(0, customerAmmount, random)),
                    randomPurchaseValue(random),
                    Delivery.Courier);

            purchaseService.savePurchase(purchase);
        }
    }

    public void initSiteEntries() {
        Random random = new Random();
        int customerAmmount = customerService.findAll().size();
        for (int i = 0; i < SITE_ENTRIES_AMMOUNT; i++) {
            siteEntryService.save(new SiteEntry(
                    random.nextBoolean(),
                    random.nextInt(1000),
                    customerService.findOneById(randomIdFromRange(0, customerAmmount, random)),
                    generateRandomDate()
            ));
        }
    }

    public void initProducts() {
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

    private double randomPurchaseValue(Random random) {
        return random.nextDouble() * 100;
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

    private Long randomIdFromRange(int start, int end, Random random) {
        long randomLong = (long) (random.nextInt((end - start)) + start);
        return randomLong > 0 && randomLong < end ? randomLong : 1;
    }
}