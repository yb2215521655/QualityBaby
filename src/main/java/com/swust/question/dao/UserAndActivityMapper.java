package com.swust.question.dao;

import com.swust.question.entity.UserAndActivity;

public interface UserAndActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAndActivity record);

    int insertSelective(UserAndActivity record);

    UserAndActivity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAndActivity record);

    int updateByPrimaryKey(UserAndActivity record);
}