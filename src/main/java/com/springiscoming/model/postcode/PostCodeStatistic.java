package com.springiscoming.model.postcode;

/**
 * Created by Mateusz on 05.06.2016.
 */
public class PostCodeStatistic {

    private String postCode;
    private Long value;
    private String district;

    public PostCodeStatistic(String postCode, Long value, String district) {
        this.postCode = postCode;
        this.value = value;
        this.district = district;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
