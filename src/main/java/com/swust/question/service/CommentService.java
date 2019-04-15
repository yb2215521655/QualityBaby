package com.swust.question.service;

import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.common.restful.UnicomRuntimeException;
import com.swust.question.dao.CommentDAO;
import com.swust.question.dao.UserAndCommentDAO;
import com.swust.question.dao.UserDAO;
import com.swust.question.entity.Comment;
import com.swust.question.entity.UserAndComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 留言事务层
 * @Author: yangbin
 * @Time: 2019/4/6 23:55
 */
@Service
public class CommentService {
    @Autowired
    private CommentDAO commentDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserAndCommentDAO userAndCommentDAO;

    /**
     * @Description: 根据id获取用户留言
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/6 23:31
     */
    public Comment getCommentById(int id){
        return commentDAO.getOne(id);
    }

    /**
     * @description: 获取所有留言实体
     * @param:
     * @return:
     * @author: yangbin
     * @date: 2019/3/30 20:03
     */
    public List<Comment> getAllComment(){
        return commentDAO.findAll();
    }

    /**
     * @Description: 分页获取所有留言实体
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/6 23:35
     */
    public List<Comment> getAllComment(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return commentDAO.findAll(pageable).getContent();
    }

    /**
     * @Description: 添加留言信息
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/6 23:35
     */
    public Comment addComment(Comment comment){
        return commentDAO.save(comment);
    }

    /**
     * @Description: 修改留言信息
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/6 23:35
     */
    public Comment editComment(Comment comment) {
        if (comment.getCommentId() == 0) {
            throw new UnicomRuntimeException(UnicomResponseEnums.ILLEGAL_ARGUMENT,"id不能为空");
        }
        return commentDAO.saveAndFlush(comment);
    }

    /**
     * @Description: 根据id删除留言信息实体
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/6 23:35
     */
    public void deleteComment(int id){
        commentDAO.deleteById(id);
    }

    /**
     * @Description: 根据用户留言实体删除
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/6 23:34
     */
    public void deleteComment(Comment comment) {
        commentDAO.deleteById(comment.getCommentId());
    }

    /**
     * @Description: 根据用户id获取用户留言列表
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 16:57
     */
    public List<Comment> getCommentByUserId(int userId){
        List<UserAndComment> list = userAndCommentDAO.findAllByUser_UserId(userId);
        List<Comment> commentList=list.stream()
                .map(UserAndComment::getComment)
                .collect(Collectors.toList());
        return commentList;
    }
    /**
     * @Description: 根据用户id获取用户留言列表(分页)
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 16:57
     */
    public List<Comment> getTagByUserId(int userId,int pageNumber,int pageSize){
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
        List<UserAndComment> list = userAndCommentDAO.findAllByUser_UserId(userId,pageable).getContent();
        List<Comment> commentList=list.stream()
                .map(UserAndComment::getComment)
                .collect(Collectors.toList());
        return commentList;
    }

    /**
     * @Description: 获得总数
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 17:00
     */
    public int getSumComment(){
        return (int) commentDAO.count();
    }

    /**
     * @Description: 获得条件查询以后的总数
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 17:01
     */
    public int getSumComment(int userId){
        return (int)userAndCommentDAO.countByUser_UserId(userId);
    }

}
