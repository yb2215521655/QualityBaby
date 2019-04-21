package com.swust.question.service;

import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.common.restful.UnicomRuntimeException;
import com.swust.question.dao.AnswerDAO;
import com.swust.question.dao.OptionDAO;
import com.swust.question.dao.QuestionDAO;
import com.swust.question.dao.QuestionnaireDAO;
import com.swust.question.entity.Questionnaire;
import com.swust.question.entity.Question;
import com.swust.question.entity.Option;
import com.swust.question.entity.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author phantaci
 * @version V1.0
 * @ClassName: QuestionnaireService
 * @Package com.swust.question.service
 * @description: Questionnaire事务层
 * @date 2019/3/23 16:32
 */
@Service
public class QuestionnaireService {
    @Autowired
    private QuestionnaireDAO questionnaireDAO;
    @Autowired
    private QuestionDAO questionDAO;
    @Autowired
    private OptionDAO optionDAO;


    /**
     * 根据id获取问卷实体
     *
     * @param id
     * @return com.swust.question.entity.Questionnaire
     * @author phantaci
     * @date 2019/3/23
     */
    public Questionnaire getQuestionnaireById(int id) {
        return questionnaireDAO.getOne(id);
    }

    /**
     * 获取所有问卷的实体
     *
     * @param
     * @return java.util.List<com.swust.question.entity.Questionnaire>
     * @author phantaci
     * @date 2019/3/23
     */
    public List<Questionnaire> getAllQuestionnaire(){ return questionnaireDAO.findAll();}

    /**
     * 分页获取所有问卷实体
     *
     * @param pageNumber 页码
     * @param pageSize   每页大小
     * @return org.springframework.data.domain.Page<com.swust.question.entity.Questionnaire>
     * @author phantaci
     * @date 2019/3/23
     */
    public List<Questionnaire> getAllQuestionnaire(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return questionnaireDAO.findAll(pageable).getContent();
    }

    /**
     * 添加问卷实体
     *
     * @param
     * @return com.swust.question.entity.Questionnaire
     * @author phantaci
     * @date 2019/3/23
     */
    public Questionnaire addQuestionnaire(Questionnaire questionnaire) {
        return questionnaireDAO.save(questionnaire);
    }

    /**
     * 修改问卷实体
     *
     * @param questionnaire
     * @return com.swust.question.entity.Questionnaire
     * @author phantaci
     * @date 2019/3/23
     */
    public Questionnaire editQuestionnaire(Questionnaire questionnaire) {
        if (questionnaire.getQuestionnaireId() == 0) {
            throw new UnicomRuntimeException(UnicomResponseEnums.ILLEGAL_ARGUMENT,"id不能为空");
        }
        return questionnaireDAO.saveAndFlush(questionnaire);
    }

    /**
     * 根据id删除问卷
     *
     * @return com.swust.question.entity.Questionnaire
     * @author phantaci
     * @date 2019/3/23
     */
    public void deleteQuestionnaire(int questionnaireId){
        questionnaireDAO.deleteByid(questionnaireId);
    }

    /**
     * 根据问卷实体删除问卷
     *
     * @return com.swust.question.entity.Questionnaire
     * @author phantaci
     * @date 2019/3/23
     */
    public void deleteQuestionnaire(Questionnaire questionnaire){

        questionnaireDAO.deleteByid(questionnaire.getQuestionnaireId());
    }

    /**
     *  获得问卷总数
     * @author phantaci
     * @date 2019/4/120
     * @param
     * @return int
     */
    public int getSumQuestionnaire(){
        return (int) questionnaireDAO.count();
    }

    /**
     *  获得条件查询以后的总数
     * @author phantaci
     * @date 2019/4/20
     * @param userId
     * @return int
     */
//    public int getSumQuestionnaire(int userId){
//        return (int)userAndActivityDAO.countByUser_UserId(userId);
//    }

    /**
     * 添加问题实体
     *
     * @param
     * @return com.swust.question.entity.Question
     * @author phantaci
     * @date 2019/3/23
     */
    public Question addQuestion(Question question) {
        return questionDAO.save(question);
    }

    /**
     * 修改问题实体
     *
     * @param question
     * @return com.swust.question.entity.Questionnaire
     * @author phantaci
     * @date 2019/3/23
     */
    public Question editQuestion(Question question) {
        if (question.getQuestionId() == 0) {
            throw new UnicomRuntimeException(UnicomResponseEnums.ILLEGAL_ARGUMENT,"id不能为空");
        }
        return questionDAO.saveAndFlush(question);

    }

    /**
     * 获取所有问题的实体
     *
     * @param
     * @return java.util.List<com.swust.question.entity.Question>
     * @author phantaci
     * @date 2019/3/31
     */
    public List<Question> getAllQuestion(){ return questionDAO.findAll();}

    /**
     * 分页获取所有问题实体
     *
     * @param pageNumber 页码
     * @param pageSize   每页大小
     * @return org.springframework.data.domain.Page<com.swust.question.entity.Questionn>
     * @author phantaci
     * @date 2019/3/31
     */
    public List<Question> getAllQuestion(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return questionDAO.findAll(pageable).getContent();
    }
    /**
     * 根据id删除问题
     *
     * @return com.swust.question.entity.Question
     * @author phantaci
     * @date 2019/3/23
     */
    public void deleteQuestion(int questionId){
        questionDAO.deleteById(questionId);
    }

    /**
     * 根据问卷实体删除问卷
     *
     * @return com.swust.question.entity.Question
     * @author phantaci
     * @date 2019/3/23
     */
    public void deleteQuestion(Question question){

        questionDAO.deleteById(question.getQuestionId());
    }


    /**
     * 添加选项实体
     *
     * @param
     * @return com.swust.question.entity.Question
     * @author phantaci
     * @date 2019/3/23
     */
    public Option addOption(Option option) {
        return optionDAO.save(option);
    }

    /**
     * 修改选项实体
     *
     * @param option
     * @return com.swust.question.entity.Questionnaire
     * @author phantaci
     * @date 2019/3/23
     */
    public Option editOption(Option option) {
        if (option.getOptionId() == 0) {
            throw new UnicomRuntimeException(UnicomResponseEnums.ILLEGAL_ARGUMENT,"id不能为空");
        }
        return optionDAO.saveAndFlush(option);

    }

    /**
     * 根据id删除选项
     *
     * @return com.swust.question.entity.Question
     * @author phantaci
     * @date 2019/3/23
     */
    public void deleteOption(int optionId){
        optionDAO.deleteById(optionId);
    }

    /**
     * 根据问卷实体删除问卷
     *
     * @return com.swust.question.entity.Question
     * @author phantaci
     * @date 2019/3/23
     */
    public void deleteOption(Option option){

        optionDAO.deleteById(option.getOptionId());
    }


    /**
     * 根据问卷id获取问题
     *
     * @author phantaci
     * @date 2019/3/25
     */

    public List<Question> getQuestionByQuestionnaireId(int questionnaireId){
        List<Question> questionList = questionDAO.findAllByQuestionnaireId(questionnaireId);
        return questionList;
    }

    /**
     * 根据问题id获取选项
     *
     * @author phantaci
     * @date 2019/3/26
     */

    public List<Option> getOptionByQuestionId(int questionId){

        List<Option> optionList = optionDAO.findAllByQuestionId(questionId);
        return optionList;
    }
}
