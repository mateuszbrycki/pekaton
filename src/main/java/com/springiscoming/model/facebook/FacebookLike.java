package com.springiscoming.model.facebook;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class FacebookLike {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd", timezone = "CET")
    private Date day;

    private Integer likes;

    public FacebookLike(Date day, Integer likes) {
        this.day = day;
        this.likes = likes;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
