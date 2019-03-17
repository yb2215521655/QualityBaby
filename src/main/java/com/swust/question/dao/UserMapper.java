package com.swust.question.dao;

import com.swust.question.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer openId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer openId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}