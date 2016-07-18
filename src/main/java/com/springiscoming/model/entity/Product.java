package com.springiscoming.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long productId;

    private String code;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private Purchase purchase;

    private Float price;

    private String name;

    public Product() {
    }

    public Product(String code, Purchase purchase, Float price, String name) {
        this.code = code;
        this.purchase = purchase;
        this.price = price;
        this.name = name;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}