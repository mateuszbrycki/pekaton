package com.springiscoming.model.facebook;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FacebookReview {

    private String reviewText;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd", timezone="CET")
    private Date reviewAddDate;

    private Integer reviewValue;

    public FacebookReview(String reviewText, Date reviewAddDate, Integer reviewValue) {
        this.reviewText = reviewText;
        this.reviewAddDate = reviewAddDate;
        this.reviewValue = reviewValue;
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
}
