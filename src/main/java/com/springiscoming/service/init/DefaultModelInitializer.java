package com.springiscoming.service.init;

import com.springiscoming.model.Product;
import com.springiscoming.service.CustomerService;
import com.springiscoming.service.OrderService;
import com.springiscoming.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Service
public class DefaultModelInitializer {

    @Inject
    private OrderService orderService;

    @Inject
    private ProductService productService;

    @Inject
    private CustomerService customerService;


    @PostConstruct
    private void posConstruct() {
        Product product = new Product();
        product.setCode("code123");

        productService.save(product);
    }
}
