package com.springiscoming.service;

import com.springiscoming.exception.DistrictNotFound;
import com.springiscoming.factory.PostCodeStatisticFactory;
import com.springiscoming.model.Purchase;
import com.springiscoming.model.PurchaseStatistic;
import com.springiscoming.model.postcode.PostCodeStatistic;
import com.springiscoming.repository.PurchaseRepository;
import com.springiscoming.util.comparators.PurchaseComparator;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Service
public class PurchaseService {

    @Inject
    private PurchaseRepository purchaseRepository;

    @Inject
    private PurchaseStatisticService purchaseStatisticService;

    @Inject
    private PurchaseComparator purchaseComparator;

    @Inject
    private PostCodeStatisticFactory postCodeStatisticFactory;

    public Purchase savePurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public Purchase findPurchaseById(long purchaseId) {
        return purchaseRepository.findOne(purchaseId);
    }

    public Integer getPurchasesCounter(Long customerId) {
        return this.purchaseRepository.getPurchasesCounter(customerId);
    }

    public Float getPurchasesSummaryCost(Long customerId) {
        return this.purchaseRepository.getPurchasesSummaryCost(customerId);
    }

    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    public List<PurchaseStatistic> getPurchaseStatistics() {
        List<Purchase> purchases = purchaseRepository.findAll();
        List<PurchaseStatistic> statistics = purchaseStatisticService.getStatistics(purchases);

        Collections.sort(statistics, purchaseComparator);

        return statistics;
    }

    public List<PostCodeStatistic> getPostCodesStatistics() {
        List<PostCodeStatistic> resultArray = new ArrayList<>();

        for(Object[] temp :  this.purchaseRepository.getPostCodesStatistics()) {

            try {
                resultArray.add(this.postCodeStatisticFactory.create((String)temp[1], (Long) temp[0]));
            } catch(DistrictNotFound e) {
                //TODO mbrycki handle exception properly
            }
        }
        return resultArray;
    }
}
