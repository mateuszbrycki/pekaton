package com.springiscoming.service;

import com.springiscoming.model.Product;
import com.springiscoming.model.Purchase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Service
public class MostPopularProductService {

    @Inject
    private PurchaseService purchaseService;

    public List<Product> findMostPopular() {
        List<Purchase> purchases = purchaseService.findAll();

        return findMostPopularProducts(purchases);
    }

    private List<Product> findMostPopularProducts(List<Purchase> purchases) {
        Map<Product, Integer> productOccurrenceMap = new HashMap<>();
        countOccurences(purchases, productOccurrenceMap);

        Map<Product, Integer> sortedByOccurrence = sortByValue(productOccurrenceMap);
        return withHighestOccurences(purchases, sortedByOccurrence.keySet());
    }

    private List<Product> withHighestOccurences(List<Purchase> purchases, Set<Product> products) {
        //todo retrieve subset from products
        ArrayList<Product> p = new ArrayList<>();
        p.addAll(products);
        return p;
    }

    private void countOccurences(List<Purchase> purchases, Map<Product, Integer> productOccurenceMap) {
        for (Purchase purchase : purchases) {
            for (Product product : purchase.getProducts()) {
                if (productOccurenceMap.containsKey(product)) {
                    Integer occurence = productOccurenceMap.get(product);
                    productOccurenceMap.put(product, ++occurence);
                } else {
                    productOccurenceMap.put(product, 1);
                }
            }
        }
    }

    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> st = map.entrySet().stream();

        st.sorted(Map.Entry.comparingByValue())
                .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));

        return result;
    }
}
