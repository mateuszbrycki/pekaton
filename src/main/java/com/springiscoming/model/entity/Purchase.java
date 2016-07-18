package com.springiscoming.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springiscoming.enums.Delivery;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long purchaseId;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "productId")
    private List<Product> products;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd", timezone = "CET")
    private Date orderDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Customer customer;

    private Double value;

    @Enumerated(EnumType.STRING)
    private Delivery delivery;

    public Purchase() {
    }

    public Purchase(List<Product> products, Date orderDate, Customer customer, Double value, Delivery delivery) {
        this.products = products;
        this.orderDate = orderDate;
        this.customer = customer;
        this.value = value;
        this.delivery = delivery;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "Order{" +
                "purchaseId=" + purchaseId +
                ", products=" + products +
                ", orderDate=" + orderDate +
                ", customer=" + customer +
                ", value=" + value +
                ", delivery=" + delivery +
                '}';
    }
}