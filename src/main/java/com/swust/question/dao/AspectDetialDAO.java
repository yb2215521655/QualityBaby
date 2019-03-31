package com.swust.question.dao;

import com.swust.question.entity.AspectDetial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Description:
 * @Author: yangbin
 * @Time: 2019/3/30 21:53
 */

public interface AspectDetialDAO extends JpaRepository<AspectDetial, Integer>, PagingAndSortingRepository<AspectDetial, Integer> {
}
