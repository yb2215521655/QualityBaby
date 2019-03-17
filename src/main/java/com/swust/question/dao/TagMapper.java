package com.swust.question.dao;

import com.swust.question.entity.Tag;

public interface TagMapper {
    int deleteByPrimaryKey(Byte tagId);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Byte tagId);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}