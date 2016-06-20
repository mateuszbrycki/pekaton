package com.springiscoming.model.siteEntry;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springiscoming.model.customer.Customer;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SITE_ENTRY")
public class SiteEntry {

    @Id
    @GeneratedValue
    private String entryId;
    private Boolean isDirectEntry;
    private Integer visitTime;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd", timezone = "CET")
    private Date entryDate;

    public SiteEntry() {
    }

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
