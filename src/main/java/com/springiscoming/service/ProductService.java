package com.springiscoming.service;

import com.springiscoming.model.entity.Product;
import com.springiscoming.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ProductService {

    @Inject
    private ProductRepository productRepository;

    @Inject
    private MostPopularProductService mostPopularService;

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product findOneByCode(String code) {
        return this.productRepository.findFirstByCodeOrderByProductId(code);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public List<Product> getMostPopular() {
        return mostPopularService.findMostPopular();
    }

    public List<Product> getProductListsByPurchaseId(Long purchaseId) {
        return productRepository.getProductListsByPurchaseId(purchaseId);
    }
}
