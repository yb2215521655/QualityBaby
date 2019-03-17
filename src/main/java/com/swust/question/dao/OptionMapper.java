package com.swust.question.dao;

import com.swust.question.entity.Option;

public interface OptionMapper {
    int deleteByPrimaryKey(Integer optionId);

    int insert(Option record);

    int insertSelective(Option record);

    Option selectByPrimaryKey(Integer optionId);

    int updateByPrimaryKeySelective(Option record);

    int updateByPrimaryKey(Option record);
}