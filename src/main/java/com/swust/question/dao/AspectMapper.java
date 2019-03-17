package com.swust.question.dao;

import com.swust.question.entity.Aspect;

public interface AspectMapper {
    int deleteByPrimaryKey(Byte aspectId);

    int insert(Aspect record);

    int insertSelective(Aspect record);

    Aspect selectByPrimaryKey(Byte aspectId);

    int updateByPrimaryKeySelective(Aspect record);

    int updateByPrimaryKey(Aspect record);
}