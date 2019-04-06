package com.swust.question.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.swust.question.entity.Option;

import java.util.List;

/**
 * @author phantaci
 * @version V1.0
 * @ClassName: OptionDAO
 * @Package com.swust.question.dao
 * @date 2019/3/25 20：22
 */

public interface OptionDAO extends JpaRepository<Option,Integer>, PagingAndSortingRepository<Option,Integer> {


    /**
     * 根据问题ID查找问题里面包含的选项
     * @author phantaci
     * @version V1.0
     * @date 2019/3/26 17：00
     */
    List<Option> findAllByQuestionId(Integer questionId);
}
