package com.swust.question.service;

import com.swust.question.dao.CommentDAO;
import com.swust.question.dao.UserDAO;
import com.swust.question.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
            try {
                commentDAO.save(new Comment());
            } catch (BindException e) {

            }finally {
                return null;
            }
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
    public void deleteComment(Comment tag) {
        commentDAO.deleteById(tag.getCommentId());
    }

}
