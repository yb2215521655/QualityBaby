package com.swust.question.dao;

import com.swust.question.entity.Questionnaire;

public interface QuestionnaireMapper {
    int deleteByPrimaryKey(Integer questionnaireId);

    int insert(Questionnaire record);

    int insertSelective(Questionnaire record);

    Questionnaire selectByPrimaryKey(Integer questionnaireId);

    int updateByPrimaryKeySelective(Questionnaire record);

    int updateByPrimaryKey(Questionnaire record);
}