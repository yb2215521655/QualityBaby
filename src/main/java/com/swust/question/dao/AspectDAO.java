package com.swust.question.dao;

import com.swust.question.entity.Aspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author phantaci
 * @version V1.0
 * @ClassName: AspectDAO
 * @Package com.swust.question.dao
 * @date 2019/4/1 20：04
 */
public interface AspectDAO extends JpaRepository<Aspect,Integer>, PagingAndSortingRepository<Aspect,Integer> {

}