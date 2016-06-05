package com.springiscoming.model.facebook;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FacebookReview {

    private String reviewText;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd", timezone="CET")
    private Date reviewAddDate;

    private Integer reviewValue;

    private String userName;

    public FacebookReview(String reviewText, Date reviewAddDate, Integer reviewValue, String userName) {
        this.reviewText = reviewText;
        this.reviewAddDate = reviewAddDate;
        this.reviewValue = reviewValue;
        this.userName = userName;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Date getReviewAddDate() {
        return reviewAddDate;
    }

    public void setReviewAddDate(Date reviewAddDate) {
        this.reviewAddDate = reviewAddDate;
    }

    public Integer getReviewValue() {
        return reviewValue;
    }

    public void setReviewValue(Integer reviewValue) {
        this.reviewValue = reviewValue;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
