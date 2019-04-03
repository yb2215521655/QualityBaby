package com.swust.question.dao;

import com.swust.question.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Description:
 * @Author: yangbin
 * @Time: 2019/3/30 21:26
 */

public interface TagDAO extends JpaRepository<Tag, Integer>, PagingAndSortingRepository<Tag, Integer> {
}
