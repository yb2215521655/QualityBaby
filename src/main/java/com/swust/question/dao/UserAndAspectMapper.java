package com.swust.question.dao;

import com.swust.question.entity.UserAndAspect;

public interface UserAndAspectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAndAspect record);

    int insertSelective(UserAndAspect record);

    UserAndAspect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAndAspect record);

    int updateByPrimaryKey(UserAndAspect record);
}