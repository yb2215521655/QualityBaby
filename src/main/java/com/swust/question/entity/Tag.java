package com.swust.question.entity;

public class Tag {
    private Byte tagId;

    private String tagName;

    public Byte getTagId() {
        return tagId;
    }

    public void setTagId(Byte tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }
}