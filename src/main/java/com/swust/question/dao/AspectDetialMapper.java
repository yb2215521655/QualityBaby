package com.swust.question.dao;

import com.swust.question.entity.AspectDetial;

public interface AspectDetialMapper {
    int deleteByPrimaryKey(Integer detialId);

    int insert(AspectDetial record);

    int insertSelective(AspectDetial record);

    AspectDetial selectByPrimaryKey(Integer detialId);

    int updateByPrimaryKeySelective(AspectDetial record);

    int updateByPrimaryKey(AspectDetial record);
}