package com.springiscoming.model;

import com.springiscoming.enums.Education;
import com.springiscoming.enums.Gender;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by winio_000 on 2016-06-04.
 */

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String postCode;

    @Enumerated(EnumType.STRING)
    private Education education;

    private String eMail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", gender=" + gender +
                ", postCode='" + postCode + '\'' +
                ", education=" + education +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
