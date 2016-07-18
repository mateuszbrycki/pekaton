package com.springiscoming.model.other.recomennded;

import com.springiscoming.model.entity.Product;

import java.util.List;

public class RecommendedProduct {

    private Product product;
    private List<Product> recommendedProducts;

    public RecommendedProduct(Product product, List<Product> recommendedProducts) {
        this.product = product;
        this.recommendedProducts = recommendedProducts;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getRecommendedProducts() {
        return recommendedProducts;
    }

    public void setRecommendedProducts(List<Product> recommendedProducts) {
        this.recommendedProducts = recommendedProducts;
    }
}
