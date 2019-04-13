package com.swust.question.service;

import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.common.restful.UnicomRuntimeException;
import com.swust.question.dao.*;
import com.swust.question.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 用户事务层
 * @author: yangbin
 * @time: 2019/3/30 19:48
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserAndAspectDAO userAndAspectDAO;
    @Autowired
    private UserAndStudioDAO userAndStudioDAO;
    @Autowired
    private UserAndActivityDAO userAndActivityDAO;
    @Autowired
    private UserAndTagDAO userAndTagDAO;
    @Autowired
    private CommentDAO commentDAO;

    /**
     * @description: 根据id获取用户实体
     * @param:
     * @return:
     * @author: yangbin
     * @date: 2019/3/30 20:01
     */
    public User getUserById(int id){
        return userDAO.getOne(id);
    }

    /**
     * @description: 获取所有用户实体
     * @param:
     * @return:
     * @author: yangbin
     * @date: 2019/3/30 20:03
     */
    public List<User> getAllUser(){
        return userDAO.findAll();
    }
    
    /**
     * @Description: 分页获取所有用户实体
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 20:18
     */
    public List<User> getAllUser(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return userDAO.findAll(pageable).getContent();
    }

    /**
     * @Description: 添加用户实体
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 20:28
     */
    public User addUser(User user){
        return userDAO.save(user);
    }

    /**
     * @Description: 修改用户实体
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 20:33
     */
    public User editUser(User user) {
        if (user.getUserId() == 0) {
            throw new UnicomRuntimeException(UnicomResponseEnums.ILLEGAL_ARGUMENT, "id不能为空");
        }
        return userDAO.saveAndFlush(user);
    }

    /**
     * @Description: 根据id删除用户实体
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 20:29
     */
    public void deleteUser(int id){
        userDAO.deleteById(id);
    }
    
    /**
     * @Description: 根据用户实体删除用户
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 20:31
     */
    public void deleteUser(User user){
        userDAO.deleteById(user.getUserId());
    }

    /**
     * @Description: 根据活动ID获取用户列表
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/4/13 17:27
     */
    public List<User> getUserByActivityId(int activityId){
        List<UserAndActivity> list = userAndActivityDAO.findAllByActivity_ActivityId(activityId);
        List<User> userList=list.stream()
                .map(UserAndActivity::getUser)
                .collect(Collectors.toList());
        return userList;
    }


    /**
     * @Description: 根据活动ID获取用户列表（分页）
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/4/13 17:27
     */
    public List<User> getUserByActivityId(int activityId,int pageNumber,int pageSize){
        Pageable pageable=PageRequest.of(pageNumber-1,pageSize);
        List<UserAndActivity> list = userAndActivityDAO.findAllByActivity_ActivityId(activityId,pageable).getContent();
        List<User> userList=list.stream()
                .map(UserAndActivity::getUser)
                .collect(Collectors.toList());
        return userList;
    }

    /**
     * @Description: 根据用户标签ID获取用户列表
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 17:27
     */
    public List<User> getUserByTagId(int tagId){
        List<UserAndTag> list = userAndTagDAO.findAllByTag_TagId(tagId);
        List<User> userList=list.stream()
                .map(UserAndTag::getUser)
                .collect(Collectors.toList());
        return userList;
    }

    /**
     * @Description: 根据用户标签ID获取用户列表（分页）
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 17:27
     */
    public List<User> getUserByTagId(int tagId,int pageNumber,int pageSize){
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
        List<UserAndTag> list = userAndTagDAO.findAllByTag_TagId(tagId,pageable).getContent();
        List<User> userList=list.stream()
                .map(UserAndTag::getUser)
                .collect(Collectors.toList());
        return userList;
    }

    /**
     * @Description: 根据用户留言id获取用户列表
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 16:57
     */
    public List<User> getUserByCommentId(int commentId){
        List<Comment> list = commentDAO.findAllByComment_CommentId(commentId);
        List<User> userList=list.stream()
                .map(Comment::getCommentSenderUser)
                .collect(Collectors.toList());
        return userList;
    }
    /**
     * @Description: 根据用户留言id获取用户列表(分页)
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 16:57
     */
    public List<User> getUserByCommentId(int commentId,int pageNumber,int pageSize){
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
        List<Comment> list = commentDAO.findAllByComment_CommentId(commentId,pageable).getContent();
        List<User> userList=list.stream()
                .map(Comment::getCommentSenderUser)
                .collect(Collectors.toList());
        return userList;
    }

    /**
     * @Description: 获得总数
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 17:30
     */
    public int getSumUser(){
        return (int) userDAO.count();
    }

    /**
     * @Description: 获得条件查询以后的总数
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 17:32
     */
    public int getSumUserByActivity(int activityId){
        return (int)userAndActivityDAO.countByActivity_ActivityId(activityId);
    }

    public int getSumUserByTag(int tagId){
        return (int)userAndTagDAO.countByTag_TagId(tagId);
    }

    public int getSumUserByComment(int commentId){
        return (int)commentDAO.countByComment_CommentId(commentId);
    }
}
