package com.swust.question.dao;

import com.swust.question.entity.UserAndStudio;

public interface UserAndStudioMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAndStudio record);

    int insertSelective(UserAndStudio record);

    UserAndStudio selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAndStudio record);

    int updateByPrimaryKey(UserAndStudio record);
}