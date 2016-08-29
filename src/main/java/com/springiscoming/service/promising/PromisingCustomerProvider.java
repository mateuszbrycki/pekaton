package com.springiscoming.service.promising;

import com.springiscoming.exception.InvalidArgumentException;
import com.springiscoming.model.Customer;
import com.springiscoming.model.promising.PromisingCustomer;
import com.springiscoming.service.FactorCalculator;
import com.springiscoming.service.PurchaseService;
import com.springiscoming.service.SiteEntryService;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by winio_000 on 2016-06-19.
 */

@Named
public class PromisingCustomerProvider {

    private static final Logger LOGGER = Logger.getLogger(PromisingCustomerProvider.class);

    @Inject
    private FactorCalculator factorCalculator;

    @Inject
    private SiteEntryService siteEntryService;

    @Inject
    private PurchaseService purchaseService;

    public PromisingCustomer get(Customer customer) {
        Long customerId = customer.getCustomerId();

        checkCustomerId(customerId);
        Float averageVisitTime = siteEntryService.getCustomerAverageVisitTime(customerId);
        Integer visitsCount = siteEntryService.getCustomerVisitsCounter(customerId);
        Integer directVisitsCount = siteEntryService.getCustomerDirectVisitsCounter(customerId);
        Integer purchasesCount = purchaseService.getPurchasesCounter(customerId);
        Float purchasesSummaryCost = purchaseService.getPurchasesSummaryCost(customerId);
        Float factor = factorCalculator.computeFactor(averageVisitTime, visitsCount, directVisitsCount, purchasesCount, purchasesSummaryCost);

        return new PromisingCustomer(customer, averageVisitTime, visitsCount, directVisitsCount, purchasesCount, purchasesSummaryCost, factor);
    }

    private void checkCustomerId(Long customerId) {
        if (customerId == null) {
            String msg = "Error while creating PromisingCustomer. Given customerId is null.";
            LOGGER.error(msg);
            throw new InvalidArgumentException(msg);
        }
    }
}