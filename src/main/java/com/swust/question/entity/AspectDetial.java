package com.swust.question.entity;

public class AspectDetial {
    private Integer detialId;

    private String detialName;

    private Byte aspectId;

    public Integer getDetialId() {
        return detialId;
    }

    public void setDetialId(Integer detialId) {
        this.detialId = detialId;
    }

    public String getDetialName() {
        return detialName;
    }

    public void setDetialName(String detialName) {
        this.detialName = detialName == null ? null : detialName.trim();
    }

    public Byte getAspectId() {
        return aspectId;
    }

    public void setAspectId(Byte aspectId) {
        this.aspectId = aspectId;
    }
}