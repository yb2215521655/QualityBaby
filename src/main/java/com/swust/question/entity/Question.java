package com.swust.question.entity;

public class Question {
    private Integer questionId;

    private String questionDetial;

    private Integer questionnaireId;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionDetial() {
        return questionDetial;
    }

    public void setQuestionDetial(String questionDetial) {
        this.questionDetial = questionDetial == null ? null : questionDetial.trim();
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
}