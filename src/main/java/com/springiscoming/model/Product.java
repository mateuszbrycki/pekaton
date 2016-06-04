package com.springiscoming.model;

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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PURCHASE_ID")
    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product() {
    }

    public Product(String code, Purchase purchase) {
        this.code = code;
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", code='" + code + '\'' +
                '}';
    }
}
