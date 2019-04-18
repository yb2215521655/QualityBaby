package com.swust.question.service;

import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.common.restful.UnicomRuntimeException;
import com.swust.question.dao.TagDAO;
import com.swust.question.dao.UserAndTagDAO;
import com.swust.question.dao.UserDAO;
import com.swust.question.entity.Activity;
import com.swust.question.entity.Tag;
import com.swust.question.entity.UserAndActivity;
import com.swust.question.entity.UserAndTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 标签事务层
 * @Author: yangbin
 * @Time: 2019/4/6 23:26
 */

@Service
public class TagService {
    @Autowired
    private TagDAO tagDAO;
    @Autowired
    private UserAndTagDAO userAndTagDAO;

    /**
     * @Description: 根据id获取用户标签
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/4/6 23:31
     */
    public Tag getTagById(int id){
        return tagDAO.getOne(id);
    }

    /**
     * @description: 获取所有用户实体
     * @param:
     * @return:
     * @author: yangbin
     * @date: 2019/3/30 20:03
     */
    public List<Tag> getAllTag(){
        return tagDAO.findAll();
    }

    /**
     * @Description: 分页获取所有用户标签实体
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/4/6 23:35
     */
    public List<Tag> getAllTag(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return tagDAO.findAll(pageable).getContent();
    }

    /**
     * @Description: 添加用户标签
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/4/6 23:35
     */
    public Tag addTag(Tag tag){
        return tagDAO.save(tag);
    }
    
    /**
     * @Description: 修改用户标签，需要标签ID
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/4/6 23:35
     */
    public Tag editTag(Tag tag) {
        if (tag.getTagId() == 0) {
            throw new UnicomRuntimeException(UnicomResponseEnums.ILLEGAL_ARGUMENT,"id不能为空");
        }
        return tagDAO.saveAndFlush(tag);
    }
    
    /**
     * @Description: 根据id删除用户标签实体
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/4/6 23:35
     */
    public void deleteTag(int id){
        tagDAO.deleteById(id);
    }
    
    /**
     * @Description: 根据用户标签实体删除
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/4/6 23:34
     */
    public void deleteTag(Tag tag) {
        tagDAO.deleteById(tag.getTagId());
    }

    /**
     * @Description: 根据用户id获取用户标签列表
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/4/13 16:57
     */
    public List<Tag> getTagByUserId(int userId){
        List<UserAndTag> list = userAndTagDAO.findAllByUser_UserId(userId);
        List<Tag> tagList=list.stream()
                .map(UserAndTag::getTag)
                .collect(Collectors.toList());
        return tagList;
    }
    /**
     * @Description: 根据用户id获取用户标签列表(分页)
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 16:57
     */
    public List<Tag> getTagByUserId(int userId,int pageNumber,int pageSize){
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
        List<UserAndTag> list = userAndTagDAO.findAllByUser_UserId(userId,pageable).getContent();
        List<Tag> tagList=list.stream()
                .map(UserAndTag::getTag)
                .collect(Collectors.toList());
        return tagList;
    }

    /**
     * @Description: 获得总数
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 17:00
     */
    public int getSumTag(){
        return (int) tagDAO.count();
    }

    /**
     * @Description: 获得条件查询以后的总数
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 17:01
     */
    public int getSumTag(int userId){
        return (int)userAndTagDAO.countByUser_UserId(userId);
    }
}
