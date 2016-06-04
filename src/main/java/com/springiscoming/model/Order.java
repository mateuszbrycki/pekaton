package com.springiscoming.model;

import com.springiscoming.enums.Delivery;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Entity
@Table(name = "ORDER")
public class Order {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    private HashMap<Product, Integer> products;

    private Date orderDate;

    @OneToOne
    private Customer customer;

    private Double value;

    @Enumerated(EnumType.STRING)
    private Delivery delivery;

    private HashMap<Product, Integer> productsReturned;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
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

    public HashMap<Product, Integer> getProductsReturned() {
        return productsReturned;
    }

    public void setProductsReturned(HashMap<Product, Integer> productsReturned) {
        this.productsReturned = productsReturned;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", products=" + products +
                ", orderDate=" + orderDate +
                ", customer=" + customer +
                ", value=" + value +
                ", delivery=" + delivery +
                ", productsReturned=" + productsReturned +
                '}';
    }
}
