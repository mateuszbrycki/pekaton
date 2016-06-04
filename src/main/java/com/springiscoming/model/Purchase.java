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

    @Id
    @GeneratedValue
    private Long purchaseId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "productId")
    private List<Product> products;

    private Date orderDate;

    @OneToOne
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Customer customer;

    private Double value;

    @Enumerated(EnumType.STRING)
    private Delivery delivery;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//    @JoinColumn(name = "productId")
//    private List<Product> productsReturned;

    public Purchase(List<Product> products, Date orderDate, Customer customer, Double value, Delivery delivery, List<Product> productsReturned) {
        this.products = products;
        this.orderDate = orderDate;
        this.customer = customer;
        this.value = value;
        this.delivery = delivery;
//        this.productsReturned = productsReturned;
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

//    public List<Product> getProductsReturned() {
////        return productsReturned;
//    }

//    public void setProductsReturned(List<Product> productsReturned) {
//        this.productsReturned = productsReturned;
//    }

    @Override
    public String toString() {
        return "Order{" +
                "purchaseId=" + purchaseId +
                ", products=" + products +
                ", orderDate=" + orderDate +
                ", customer=" + customer +
                ", value=" + value +
                ", delivery=" + delivery +
//                ", productsReturned=" + productsReturned +
                '}';
    }
}
