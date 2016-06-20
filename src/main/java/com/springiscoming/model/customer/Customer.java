package com.springiscoming.model.customer;

import com.springiscoming.enums.Education;
import com.springiscoming.enums.Gender;

import javax.persistence.*;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue
    private Long customerId;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String postCode;

    @Enumerated(EnumType.STRING)
    private Education education;

    private String eMail;

    public Customer() {
    }

    public Customer(Gender gender, String postCode, Education education, String eMail) {
        this.gender = gender;
        this.postCode = postCode;
        this.education = education;
        this.eMail = eMail;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", gender=" + gender +
                ", postCode='" + postCode + '\'' +
                ", education=" + education +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
