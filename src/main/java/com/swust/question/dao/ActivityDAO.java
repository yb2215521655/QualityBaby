package com.swust.question.dao;

import com.swust.question.entity.Activity;
import com.swust.question.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ActivityDAO
 * @Package com.swust.question.dao
 * @description: 活动类DAO层
 * @date 2019/3/23 13:31
 */
public interface ActivityDAO extends JpaRepository<Activity,Integer>, PagingAndSortingRepository<Activity,Integer> {

}
