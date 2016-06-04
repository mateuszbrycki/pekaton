package com.springiscoming.model;

import javax.persistence.*;

@Entity
@Table(name = "SITE_ENTRY")
public class SiteEntry {

    @Id
    @GeneratedValue
    private String entryId;

    private Boolean isDirectEntry;

    private Integer visitTime;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id")
    private Customer customer;

    public SiteEntry() {}

    public SiteEntry(Boolean isDirectEntry, Integer visitTime, Customer customer) {
        this.isDirectEntry = isDirectEntry;
        this.visitTime = visitTime;
        this.customer = customer;
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

    @Override
    public String toString() {
        return "SiteEntry{" +
                "entryId='" + entryId + '\'' +
                ", isDirectEntry=" + isDirectEntry +
                ", visitTime=" + visitTime +
                ", customer=" + customer +
                '}';
    }
}
