package com.swust.question.entity;

public class Option {
    private Integer optionId;

    private String optionDetial;

    private Byte optionOrder;

    private Integer questionId;

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getOptionDetial() {
        return optionDetial;
    }

    public void setOptionDetial(String optionDetial) {
        this.optionDetial = optionDetial == null ? null : optionDetial.trim();
    }

    public Byte getOptionOrder() {
        return optionOrder;
    }

    public void setOptionOrder(Byte optionOrder) {
        this.optionOrder = optionOrder;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}