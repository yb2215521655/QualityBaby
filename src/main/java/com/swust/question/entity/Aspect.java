package com.swust.question.entity;

public class Aspect {
    private Byte aspectId;

    private String aspectName;

    public Byte getAspectId() {
        return aspectId;
    }

    public void setAspectId(Byte aspectId) {
        this.aspectId = aspectId;
    }

    public String getAspectName() {
        return aspectName;
    }

    public void setAspectName(String aspectName) {
        this.aspectName = aspectName == null ? null : aspectName.trim();
    }
}