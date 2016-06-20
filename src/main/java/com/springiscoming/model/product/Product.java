package com.springiscoming.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springiscoming.model.purchase.Purchase;

import javax.persistence.*;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Entity
@Table(name = "PRODUCT")
public class Product {

    private Long productId;
    private String code;
    private Purchase purchase;
    private Float price;
    private String name;

    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Column
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PURCHASE_ID")
    public Purchase getPurchase() {
        return purchase;
    }

    @Column
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product() {
    }

    public Product(String code, Purchase purchase, Float price, String name) {
        this.code = code;
        this.purchase = purchase;
        this.price = price;
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
