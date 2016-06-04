package com.springiscoming.service;

import com.springiscoming.model.Purchase;
import com.springiscoming.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Service
public class PurchaseService {

    @Inject
    private PurchaseRepository purchaseRepository;

    public Purchase saveOrder(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public Integer getPurchasesCounter(Long customerId) {
        return this.purchaseRepository.getPurchasesCounter(customerId);
    }

    public Float getPurchasesSummaryCost(Long customerId) {
        return this.purchaseRepository.getPurchasesSummaryCost(customerId);
    }
}
