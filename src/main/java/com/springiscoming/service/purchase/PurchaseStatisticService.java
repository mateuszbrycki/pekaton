package com.springiscoming.service.purchase;

import com.springiscoming.model.purchase.Purchase;
import com.springiscoming.model.purchase.PurchaseStatistic;
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
    private static Map<String, Double> valuesMap = new HashMap<>();
    private static Map<String, Integer> productsCounterMap = new HashMap<>();

    public List<PurchaseStatistic> getStatistics(List<Purchase> purchases) {
        for (Purchase purchase : purchases) {
            Date orderDate = purchase.getOrderDate();
            Double value = purchase.getValue();
            Integer productCounter = purchase.getProducts().size();
            String formattedDate = formatDate(orderDate);
            if (datesCounterMap.containsKey(formattedDate)) {
                Integer counter = datesCounterMap.get(formattedDate);
                datesCounterMap.put(formattedDate, ++counter);
                Double v = valuesMap.get(formattedDate);
                valuesMap.put(formattedDate, value + v);
                Integer pCounter = productsCounterMap.get(formattedDate);
                productsCounterMap.put(formattedDate, pCounter + productCounter);
            } else {
                datesCounterMap.put(formattedDate, 1);
                valuesMap.put(formattedDate, value);
                productsCounterMap.put(formattedDate, 1);
            }
        }
        return datesCounterMap.keySet().stream().map(s -> new PurchaseStatistic(s, datesCounterMap.get(s), productsCounterMap.get(s), valuesMap.get(s))).collect(Collectors.toList());
    }

    private String formatDate(Date orderDate) {
        return dateFormatter.formatDate(orderDate);
    }
}