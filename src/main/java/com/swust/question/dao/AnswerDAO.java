package com.swust.question.dao;

import com.swust.question.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.swust.question.entity.Answer;

import java.util.List;

/**
 * @author phantaci
 * @version V1.0
 * @ClassName: AnswerDAO
 * @Package com.swust.question.dao
 * @date 2019/3/25 20：23
 */

public interface AnswerDAO extends JpaRepository<Answer,Integer>, PagingAndSortingRepository<Answer,Integer> {



    /**
     * 根据用户ID查找用户回答的答案
     * @author phantaci
     * @version V1.0
     * @date 2019/3/26 17：50
     */
    List<Answer> findAnswerByUserId(Integer UserId);
}
