package com.swust.question.dao;

import com.swust.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

/**
 * @author phantaci
 * @version V1.0
 * @ClassName: QuestionDAO
 * @Package com.swust.question.dao
 * @date 2019/3/25 20：04
 */
public interface QuestionDAO extends JpaRepository<Question,Integer>, PagingAndSortingRepository<Question,Integer> {

    /**
     * 根据问卷ID查找问卷里面包含的问题
     * @author phantaci
     * @version V1.0
     * @date 2019/3/25 20：04
     */
    List<Question> findAllByQuestionnaireId(Integer questionnaireId);

}
