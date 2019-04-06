package com.swust.question.dao;

import com.swust.question.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @description:
 * @author: yangbin
 * @time: 2019/3/30 19:48
 */

public interface UserDAO extends JpaRepository<User, Integer>, PagingAndSortingRepository<User, Integer> {
}
