package com.swust.question.dao;

import com.swust.question.entity.UserAndTag;

public interface UserAndTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAndTag record);

    int insertSelective(UserAndTag record);

    UserAndTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAndTag record);

    int updateByPrimaryKey(UserAndTag record);
}