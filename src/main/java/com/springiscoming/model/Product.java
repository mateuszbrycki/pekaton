package com.springiscoming.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue
    private Long productId;

    private String code;

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

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", code='" + code + '\'' +
                '}';
    }
}
