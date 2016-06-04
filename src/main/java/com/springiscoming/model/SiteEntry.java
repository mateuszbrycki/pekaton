package com.springiscoming.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SITE_ENTRY")
public class SiteEntry {

    @Id
    @GeneratedValue
    private String id;

    private Boolean isDirectEntry;

    private Integer visitTime;

    //private Customer customer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDirectEntry() {
        return isDirectEntry;
    }

    public void setDirectEntry(Boolean directEntry) {
        isDirectEntry = directEntry;
    }

    public Integer getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Integer visitTime) {
        this.visitTime = visitTime;
    }

    /*public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "SiteEntry{" +
                "id='" + id + '\'' +
                ", isDirectEntry=" + isDirectEntry +
                ", visitTime=" + visitTime +
                ", customer=" + customer +
                '}';
    }*/
}
