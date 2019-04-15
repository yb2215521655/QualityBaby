package com.swust.question.dao;

import com.swust.question.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @Description: 留言
 * @Author: yangbin
 * @Time: 2019/4/6 23:52
 */

public interface CommentDAO extends JpaRepository<Comment, Integer>, PagingAndSortingRepository<Comment, Integer> {
}
