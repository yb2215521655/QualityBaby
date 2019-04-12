package com.swust.question.dao;

import com.swust.question.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author pang
 * @version V1.0
 * @ClassName: StudioDAO
 * @Package com.swust.question.dao
 * @description: 这里是第一个DAO层的示例，还有很多很多表，我是懒得写了，到时候大家一起来写吧
 * @date 2019/3/20 22:33
 */
public interface StudioDAO extends JpaRepository<Studio, Integer>, PagingAndSortingRepository<Studio, Integer> {
}
