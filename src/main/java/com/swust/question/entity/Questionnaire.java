package com.swust.question.entity;

public class Questionnaire {
    private Integer questionnaireId;

    private String questionnaireTitle;

    private String questionnaireIntroduction;

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getQuestionnaireTitle() {
        return questionnaireTitle;
    }

    public void setQuestionnaireTitle(String questionnaireTitle) {
        this.questionnaireTitle = questionnaireTitle == null ? null : questionnaireTitle.trim();
    }

    public String getQuestionnaireIntroduction() {
        return questionnaireIntroduction;
    }

    public void setQuestionnaireIntroduction(String questionnaireIntroduction) {
        this.questionnaireIntroduction = questionnaireIntroduction == null ? null : questionnaireIntroduction.trim();
    }
}