package com.springiscoming.web;

import com.springiscoming.model.product.Product;
import com.springiscoming.model.recomennded.RecommendedProduct;
import com.springiscoming.service.apriori.AprioriService;
import com.springiscoming.service.product.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;


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