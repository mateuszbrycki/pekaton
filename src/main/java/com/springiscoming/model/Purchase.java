package com.springiscoming.model;

import com.springiscoming.enums.Delivery;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Entity
@Table(name = "PURCHASE")
public class Purchase {

    private Long purchaseId;
    private List<Product> products;
    private Date orderDate;
    private Customer customer;
    private Double value;
    @Enumerated(EnumType.STRING)
    private Delivery delivery;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PURCHASE_ID")
    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PRODUCT_ID")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Column
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Column
    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Purchase() {
    }

    public Purchase(List<Product> products, Date orderDate, Customer customer, Double value, Delivery delivery) {
        this.products = products;
        this.orderDate = orderDate;
        this.customer = customer;
        this.value = value;
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
