package com.swust.question.service;

import com.swust.question.dao.TagDAO;
import com.swust.question.dao.UserAndTagDAO;
import com.swust.question.dao.UserDAO;
import com.swust.question.entity.Tag;
import com.swust.question.entity.UserAndTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * @Description: 修改用户标签
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/4/6 23:35
     */
    public Tag editTag(Tag tag) {
        if (tag.getTagId() == 0) {
            try {
                tagDAO.save(new Tag());
            } catch (BindException e) {

            }finally {
                return null;
            }
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
}
