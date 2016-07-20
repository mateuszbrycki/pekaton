package com.springiscoming.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long productId;

    private String code;

    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    private Set<Purchase> purchases;

    private Float price;

    private String name;

    public Product() {
    }

    public Product(String code, Float price, String name) {
        this.code = code;
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

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
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