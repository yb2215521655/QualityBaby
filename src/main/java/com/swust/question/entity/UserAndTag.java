package com.swust.question.entity;

public class UserAndTag {
    private Integer id;

    private Integer openId;

    private Byte tagId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOpenId() {
        return openId;
    }

    public void setOpenId(Integer openId) {
        this.openId = openId;
    }

    public Byte getTagId() {
        return tagId;
    }

    public void setTagId(Byte tagId) {
        this.tagId = tagId;
    }
}