package com.swust.question.service;

import com.swust.question.dao.UserAndActivityDAO;
import com.swust.question.dao.UserAndAspectDAO;
import com.swust.question.dao.UserAndStudioDAO;
import com.swust.question.dao.UserDAO;
import com.swust.question.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
            try {
                userDAO.save(new User());
            } catch (BindException e) {

            }finally {
                return null;
            }
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
}
