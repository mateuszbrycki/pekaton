package com.springiscoming.service;

import com.springiscoming.model.Purchase;
import com.springiscoming.model.PurchaseStatistic;
import com.springiscoming.util.DateFormatter;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Service
public class PurchaseStatisticService {
    @Inject
    private DateFormatter dateFormatter;

    private static Map<String, Integer> datesCounterMap = new HashMap<>();

    public List<PurchaseStatistic> getStatistics(List<Purchase> purchases) {
        for (Purchase purchase : purchases) {
            Date orderDate = purchase.getOrderDate();
            String formattedDate = formatDate(orderDate);
            if (datesCounterMap.containsKey(formattedDate)) {
                Integer counter = datesCounterMap.get(formattedDate);
                datesCounterMap.put(formattedDate, ++counter);
            } else {
                datesCounterMap.put(formattedDate, 1);
            }
        }
        return datesCounterMap.keySet().stream().map(s -> new PurchaseStatistic(s, datesCounterMap.get(s))).collect(Collectors.toList());
    }

    private String formatDate(Date orderDate) {
        return dateFormatter.formatDate(orderDate);
    }
}
