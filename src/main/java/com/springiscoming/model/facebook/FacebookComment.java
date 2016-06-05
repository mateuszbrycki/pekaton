package com.springiscoming.model.facebook;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FacebookComment {

    private String comment;
    private Integer commentCount;
    private Integer sharesCount;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd", timezone="CET")
    private Date addDate;

    public FacebookComment(String comment, Integer commentCount, Integer sharesCount, Date addDate) {
        this.comment = comment;
        this.commentCount = commentCount;
        this.sharesCount = sharesCount;
        this.addDate = addDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getSharesCount() {
        return sharesCount;
    }

    public void setSharesCount(Integer sharesCount) {
        this.sharesCount = sharesCount;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
}
