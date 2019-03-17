package com.swust.question.entity;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private Date commentTime;

    private Byte commentLike;

    private Integer commentSender;

    private String commentDetial;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Byte getCommentLike() {
        return commentLike;
    }

    public void setCommentLike(Byte commentLike) {
        this.commentLike = commentLike;
    }

    public Integer getCommentSender() {
        return commentSender;
    }

    public void setCommentSender(Integer commentSender) {
        this.commentSender = commentSender;
    }

    public String getCommentDetial() {
        return commentDetial;
    }

    public void setCommentDetial(String commentDetial) {
        this.commentDetial = commentDetial == null ? null : commentDetial.trim();
    }
}