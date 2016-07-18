package com.springiscoming.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SiteEntry {

    @Id
    @GeneratedValue
    private String entryId;

    private Boolean isDirectEntry;

    private Integer visitTime;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    private Date entryDate;

    public SiteEntry(Boolean isDirectEntry, Integer visitTime, Customer customer, Date entryDate) {
        this.isDirectEntry = isDirectEntry;
        this.visitTime = visitTime;
        this.customer = customer;
        this.entryDate = entryDate;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "SiteEntry{" +
                "entryId='" + entryId + '\'' +
                ", isDirectEntry=" + isDirectEntry +
                ", visitTime=" + visitTime +
                ", customer=" + customer +
                ", entryDate=" + entryDate +
                '}';
    }
}