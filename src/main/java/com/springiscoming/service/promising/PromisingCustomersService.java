package com.springiscoming.service.promising;

import com.springiscoming.model.Customer;
import com.springiscoming.model.promising.PromisingCustomer;
import com.springiscoming.service.CustomerService;
import com.springiscoming.service.PurchaseService;
import com.springiscoming.service.SiteEntryService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
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
    private SiteEntryService siteEntryService;

    @Inject
    private PurchaseService purchaseService;

    public List<PromisingCustomer> findPromisingCustomersList() {

        List<PromisingCustomer> result = new ArrayList<>();
        List<Customer> customersList = customerService.findAll();

        for(Customer customer : customersList) {

            PromisingCustomer promisingCustomer = new PromisingCustomer();
            promisingCustomer.setCustomer(customer);

            Float promisingCustomerFactor = calculatePromisingFactor(promisingCustomer);

            if(promisingCustomerFactor != null && promisingCustomerFactor > 0) {
                promisingCustomer.setFactor(promisingCustomerFactor);
                result.add(promisingCustomer);
            }
        }

        return result;

    }

    private Float calculatePromisingFactor(PromisingCustomer promisingCustomer) {

        Long customerId = promisingCustomer.getCustomer().getCustomerId();

        //prepare factor data
        Float averageVisitTime = siteEntryService.getCustomerAverageVisitTime(customerId);
        Integer visitsCount = siteEntryService.getCustomerVisitsCounter(customerId);
        Integer directVisitsCount = siteEntryService.getCustomerDirectVisitsCounter(customerId);

        Integer purchasesCount = purchaseService.getPurchasesCounter(customerId);
        Float purchasesSummaryCost = purchaseService.getPurchasesSummaryCost(customerId);

        promisingCustomer.setAverageVisitTime(averageVisitTime);
        promisingCustomer.setVisitsCount(visitsCount);
        promisingCustomer.setDirectVisitsCount(directVisitsCount);

        promisingCustomer.setPurchasesCount(purchasesCount);
        promisingCustomer.setPurchasesSummaryCost(purchasesSummaryCost);

        System.out.println("CustomerId: " + customerId +
                ", averageVisitTime: " + averageVisitTime +
                ", purchasesCount: " + purchasesCount +
                ", directVisitsCount: " + directVisitsCount +
                ", purchasesSummaryCost: " + purchasesSummaryCost +
                ", visitsCount: " + visitsCount);


        Float visitCountFactor = new BigDecimal(Math.pow(visitsCount.doubleValue(), 2)).floatValue() * 0.1f;
        Float directVisitsFactor = directVisitsCount* 0.1f;
        Float averageVisitsFactor = averageVisitTime * 0.2f;

        Float purchasesCountFactor = purchasesCount * 0.4f;
        Float purchasesProportionFactor = (purchasesSummaryCost / purchasesCount) * 0.5f;

        Float factor = (purchasesCountFactor * directVisitsFactor * purchasesProportionFactor * averageVisitsFactor) / (visitCountFactor * 100);

        return factor;
    }
}
