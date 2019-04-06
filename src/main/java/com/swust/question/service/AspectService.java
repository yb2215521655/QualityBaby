package com.swust.question.service;

import com.swust.question.dao.AspectDAO;
import com.swust.question.dao.UserAndAspectDAO;
import com.swust.question.entity.Aspect;
import com.swust.question.entity.UserAndAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: yangbin
 * @Time: 2019/3/30 21:12
 */

@Service
public class AspectService {
    @Autowired
    private AspectDAO aspectDAO;
    @Autowired
    private UserAndAspectDAO userAndAspectDAO;
    
    /**
     * @Description: 根据id获取雷达图
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 21:29
     */
    public Aspect getAspectById(int aspectId) {
        return aspectDAO.getOne(aspectId);
    }
    
    /**
     * @Description: 根据雷达图实体获取雷达图
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 21:34
     */
    public List<Aspect> getAllAspect() {
        return aspectDAO.findAll();
    }
    
    /**
     * @Description: 分页获取所有雷达图
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 21:35
     */
    public List<Aspect> getAllAspect(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return aspectDAO.findAll(pageable).getContent();
    }
    
    /**
     * @Description: 添加雷达图
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 21:35
     */
    public Aspect addAspect(Aspect aspect) {
        return aspectDAO.save(aspect);
    }

    /**
     * @Description: 修改雷达图
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 21:35
     */
    public Aspect editAspect(Aspect aspect) {
        if (aspect.getAspectId() == 0) {
            try {
                aspectDAO.save(new Aspect());
            } catch (BindException e) {

            } finally {
                return null;
            }
        }
        return aspectDAO.saveAndFlush(aspect);
    }
    
    /**
     * @Description: 根据雷达图实体删除雷达图
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 21:36
     */
    public void deleteAspect(Aspect aspect) {
        aspectDAO.deleteById(aspect.getAspectId());
    }

    /**
     * @Description: 根据id删除雷达图
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 21:37
     */
    public void deleteAspect(int aspectId) {
        aspectDAO.deleteById(aspectId);
    }

    public List<Aspect> getAspectByUserId(int userId){
        List<UserAndAspect> list = userAndAspectDAO.findAllByAspect_AspectId(userId);
        List<Aspect> aspectList = list.stream()
                .map(UserAndAspect::getAspect)
                .collect(Collectors.toList());
        return aspectList;
    }
}
