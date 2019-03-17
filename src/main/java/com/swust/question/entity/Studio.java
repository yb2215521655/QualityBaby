package com.swust.question.entity;

public class Studio {
    private Integer studioId;

    private String studioTitle;

    private String studioInformation;

    public Integer getStudioId() {
        return studioId;
    }

    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
    }

    public String getStudioTitle() {
        return studioTitle;
    }

    public void setStudioTitle(String studioTitle) {
        this.studioTitle = studioTitle == null ? null : studioTitle.trim();
    }

    public String getStudioInformation() {
        return studioInformation;
    }

    public void setStudioInformation(String studioInformation) {
        this.studioInformation = studioInformation == null ? null : studioInformation.trim();
    }
}