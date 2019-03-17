package com.swust.question.entity;

public class User {
    private Integer openId;

    private Integer tellNumber;

    private String className;

    private Boolean userGender;

    private Integer stuId;

    public Integer getOpenId() {
        return openId;
    }

    public void setOpenId(Integer openId) {
        this.openId = openId;
    }

    public Integer getTellNumber() {
        return tellNumber;
    }

    public void setTellNumber(Integer tellNumber) {
        this.tellNumber = tellNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Boolean getUserGender() {
        return userGender;
    }

    public void setUserGender(Boolean userGender) {
        this.userGender = userGender;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }
}