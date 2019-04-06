package com.swust.question.dao;

import com.swust.question.entity.Aspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Description:
 * @Author: yangbin
 * @Time: 2019/3/30 21:13
 */

public interface AspectDAO extends JpaRepository<Aspect, Integer>, PagingAndSortingRepository<Aspect, Integer> {
}
