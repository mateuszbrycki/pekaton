package com.springiscoming.service;

import com.springiscoming.model.Product;
import com.springiscoming.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by winio_000 on 2016-06-04.
 */
@Service
public class ProductService {

    @Inject
    private ProductRepository productRepository;

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
