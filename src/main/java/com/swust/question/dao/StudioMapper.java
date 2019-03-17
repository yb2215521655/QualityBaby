package com.swust.question.dao;

import com.swust.question.entity.Studio;

public interface StudioMapper {
    int deleteByPrimaryKey(Integer studioId);

    int insert(Studio record);

    int insertSelective(Studio record);

    Studio selectByPrimaryKey(Integer studioId);

    int updateByPrimaryKeySelective(Studio record);

    int updateByPrimaryKey(Studio record);
}