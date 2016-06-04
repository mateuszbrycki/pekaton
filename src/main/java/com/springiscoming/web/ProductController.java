package com.springiscoming.web;

import com.springiscoming.model.Product;
import com.springiscoming.model.recomennded.RecommendedProduct;
import com.springiscoming.service.ProductService;
import com.springiscoming.service.apriori.AprioriService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

/**
 * Created by winio_000 on 2016-06-04.
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Inject
    private ProductService productService;

    @Inject
    private AprioriService aprioriService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> findAllProducts() {
        return productService.getAll();
    }

    @RequestMapping(path = "/popular", method = RequestMethod.GET)
    public List<Product> findMostPopularProducts() {
        return productService.getMostPopular();
    }

    @RequestMapping(path = "/recommend", method = RequestMethod.GET)
    public List<RecommendedProduct> getRecommendedProducts() {
        List<RecommendedProduct> associationRules = aprioriService.getAssociationRules();
        return associationRules;
    }
}