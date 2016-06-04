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

    @Inject
    private ProductService productService;

    public List<Product> findMostPopular() {
        List<Purchase> purchases = purchaseService.findAll();

        return findMostPopularProducts(purchases);
    }

    private List<Product> findMostPopularProducts(List<Purchase> purchases) {
        Map<String, Integer> codeOccurrenceMap = new HashMap<>();
        Map<Product, Integer> productOccurenceMap = countOccurrences(purchases, codeOccurrenceMap);

        Map<Product, Integer> sortedByOccurrence = sortByValue(productOccurenceMap);
        Set<Product> products = sortedByOccurrence.keySet();

        if (products.size() < purchases.size()) {
            return new ArrayList<>(products);
        }
        return withHighestOccurrences(purchases, products);
    }

    private Map<Product, Integer> countOccurrences(List<Purchase> purchases, Map<String, Integer> productCodeOccurenceMap) {
        for (Purchase purchase : purchases) {
            for (Product product : purchase.getProducts()) {

                String code = product.getCode();
                if (productCodeOccurenceMap.containsKey(code)) {
                    Integer occurrence = productCodeOccurenceMap.get(code);
                    productCodeOccurenceMap.put(code, ++occurrence);
                } else {
                    productCodeOccurenceMap.put(code, 1);
                }
            }
        }

        return getProductWithOccurrences(purchases, productCodeOccurenceMap);
    }

    private Map<Product, Integer> getProductWithOccurrences(List<Purchase> purchases, Map<String, Integer> productCodeOccurenceMap) {
        Map<Product, Integer> productOccurrenceMap = new HashMap<>();

        List<Product> products = productService.getAll();
        for(String code : productCodeOccurenceMap.keySet()) {
            Product productByCode = products.stream().filter(product -> product.getCode().equals(code)).findFirst().get();
            productOccurrenceMap.put(productByCode, productCodeOccurenceMap.get(code));
        }
        return productOccurrenceMap;
    }

    private List<Product> withHighestOccurrences(List<Purchase> purchases, Set<Product> products) {
        List<Product> list = new ArrayList<>(products);
        return list.subList(0, purchases.size());
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
