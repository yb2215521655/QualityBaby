package com.swust.question.service;

import com.swust.question.dao.AnswerDAO;
import com.swust.question.entity.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author phantaci
 * @version V1.0
 * @ClassName: AnswerService
 * @Package com.swust.question.service
 * @description: Answer事务层
 * @date 2019/3/30 16:32
 */
@Service
public class AnswerService {
    @Autowired
    private AnswerDAO answerDAO;

    /**
     * 根据id获取答案实体
     *
     * @param id
     * @return com.swust.question.entity.Answer
     * @author phantaci
     * @date 2019/3/30
     */
    public Answer getAnswerById(int id) {
        return answerDAO.getOne(id);
    }

    /**
     * 获取所有答案的实体
     *
     * @param
     * @return java.util.List<com.swust.question.entity.Answer>
     * @author phantaci
     * @date 2019/3/30
     */
    public List<Answer> getAllAnswer(){ return answerDAO.findAll();}

    /**
     * 分页获取所有问卷实体
     *
     * @param pageNumber 页码
     * @param pageSize   每页大小
     * @return org.springframework.data.domain.Page<com.swust.question.entity.Answer>
     * @author phantaci
     * @date 2019/3/30
     */
    public List<Answer> getAllAnswer(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return answerDAO.findAll(pageable).getContent();
    }

    /**
     * 根据用户id获取用户答案
     *
     * @author phantaci
     * @date 2019/3/30
     */

    public List<Answer> getAnswerByUserId(int UserId){
        List<Answer> answerList = answerDAO.findAnswerByUserId(UserId);
        return answerList;
    }

    /**
     * 添加答案实体
     *
     * @param
     * @return com.swust.question.entity.Answer
     * @author phantaci
     * @date 2019/3/31
     */
    public Answer addAnswer(Answer answer) {
        return answerDAO.save(answer);
    }

    /**
     * 根据答案实体删除答案
     *
     * @return com.swust.question.entity.Answer
     * @author phantaci
     * @date 2019/3/23
     */
    public void deleteAnswerById(Answer answer){
        if(answer.getAnswerId() == 0){
            try{
                answerDAO.save(new Answer());
            }catch (BindException e) {

            } finally {
                return;
            }
        }
        answerDAO.delete(answer);
    }
}
