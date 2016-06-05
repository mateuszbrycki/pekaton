package com.springiscoming.model.postcode;

/**
 * Created by Mateusz on 05.06.2016.
 */
public class PostCodeStatistic {

    private String postCode;
    private Long value;

    public PostCodeStatistic(String postCode, Long value) {
        this.postCode = postCode;
        this.value = value;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
