package com.springiscoming.builder;

import com.springiscoming.model.product.Product;

/**
 * Created by winio_000 on 2016-06-20.
 */
public class ProductBuilder {

    private Long productId;
    private String productName;
    private String code;
    private Float price;

    private ProductBuilder() {
    }

    public static ProductBuilder get() {
        return new ProductBuilder();
    }

    public ProductBuilder withId(Long productId) {
        this.productId = productId;
        return this;
    }

    public ProductBuilder withName(String productName) {
        this.productName = productName;
        return this;
    }

    public ProductBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public ProductBuilder withPrice(Float price) {
        this.price = price;
        return this;
    }

    public Product build() {
        Product product = new Product();

        product.setProductId(productId);
        product.setName(productName);
        product.setCode(code);
        product.setPrice(price);

        return product;
    }
}
