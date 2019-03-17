package com.swust.question.entity;

import java.util.Date;

public class Activity {
    private Integer activityId;

    private String activityName;

    private String activityInformation;

    private Date activityStart;

    private Date activityEnd;

    private Byte activityPeopleNumber;

    private Integer studioId;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getActivityInformation() {
        return activityInformation;
    }

    public void setActivityInformation(String activityInformation) {
        this.activityInformation = activityInformation == null ? null : activityInformation.trim();
    }

    public Date getActivityStart() {
        return activityStart;
    }

    public void setActivityStart(Date activityStart) {
        this.activityStart = activityStart;
    }

    public Date getActivityEnd() {
        return activityEnd;
    }

    public void setActivityEnd(Date activityEnd) {
        this.activityEnd = activityEnd;
    }

    public Byte getActivityPeopleNumber() {
        return activityPeopleNumber;
    }

    public void setActivityPeopleNumber(Byte activityPeopleNumber) {
        this.activityPeopleNumber = activityPeopleNumber;
    }

    public Integer getStudioId() {
        return studioId;
    }

    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
    }
}