package com.swust.question.dao;

import com.swust.question.entity.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author phantaci
 * @version V1.0
 * @ClassName: QuestionnaierDAO
 * @Package com.swust.question.dao
 * @date 2019/3/23 16:30
 */

public interface QuestionnaireDAO extends JpaRepository<Questionnaire,Integer> , PagingAndSortingRepository<Questionnaire,Integer> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM questionnaire where questionnaire_id=?1", nativeQuery = true)
    void deleteByid(int uid);
}
