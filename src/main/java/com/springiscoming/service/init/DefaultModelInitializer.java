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
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static com.springiscoming.util.DateUtils.generateRandomDate;
import static java.util.Collections.shuffle;
import static java.util.UUID.randomUUID;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Service
@Transactional
public class DefaultModelInitializer {

    private static final int PRODUCTS_IN_PURCHASE_AMOUNT = 8;
    private static final int SITE_ENTRIES_AMOUNT = 100;
    private static final int PRODUCT_CODE_LENGTH = 30;
    private static final int PURCHASE_AMOUNT = 100;
    private static final int CUSTOMER_AMOUNT = 10;
    private static final int PRODUCT_AMOUNT = 15;
    private static final int THOUSAND = 1000;
    private static final int ZERO = 0;
    private Random random = new Random();

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
        initProducts();
        initPurchases();
        initSiteEntries();
    }

    public void initProducts() {
        for (int i = ZERO; i < PRODUCT_AMOUNT; i++) {
            productService.save(new Product(randomCodeFromUUID(), random.nextFloat() * THOUSAND, "product" + i));
        }
    }

    public void initCustomers() {
        for (int i = ZERO; i < CUSTOMER_AMOUNT; i++) {
            customerService.save(new Customer(randomGender(), randomPostCode(), randomEducation(), randomEmail()));
        }
    }

    public void initPurchases() {
        List<Product> products = productService.getAll();

        for (int i = ZERO; i < PURCHASE_AMOUNT; i++) {
            shuffle(products);
            Purchase purchase = new Purchase(
                    new HashSet<>(products.subList(ZERO, PRODUCTS_IN_PURCHASE_AMOUNT)),
                    generateRandomDate(),
                    customerService.findOneById(randomIdBelow(CUSTOMER_AMOUNT)),
                    randomPurchaseValue(),
                    Delivery.Courier);

            purchaseService.savePurchase(purchase);
        }
    }

    public void initSiteEntries() {
        for (int i = ZERO; i < SITE_ENTRIES_AMOUNT; i++) {
            siteEntryService.save(new SiteEntry(
                    random.nextBoolean(),
                    random.nextInt(THOUSAND),
                    customerService.findOneById(randomIdBelow(CUSTOMER_AMOUNT)),
                    generateRandomDate()
            ));
        }
    }

    private String randomCodeFromUUID() {
        return randomUUID().toString().substring(PRODUCT_CODE_LENGTH);
    }

    private double randomPurchaseValue() {
        return random.nextDouble() * THOUSAND;
    }

    private String randomEmail() {
        return "email" + random.nextInt(THOUSAND) + "@gmail.com";
    }

    private Education randomEducation() {
        Education[] values = Education.values();
        return values[random.nextInt(values.length)];
    }

    private String randomPostCode() {
        List<String> codes = postalCodePovider.postalCodes();
        return codes.get(random.nextInt(codes.size() - 1));
    }

    private Gender randomGender() {
        Gender[] values = Gender.values();
        return values[random.nextInt(values.length)];
    }

    private Long randomIdBelow(int number) {
        long id = (long) (random.nextInt((number)));
        return isProperId(number, id) ? id : 1;
    }

    private boolean isProperId(int number, long randomIdValue) {
        return randomIdValue > ZERO && randomIdValue < number;
    }
}