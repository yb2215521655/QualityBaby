package com.swust.question.dao;

import com.swust.question.entity.UserAndAspect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description: 用户—雷达图关联表
 * @Author: yangbin
 * @Time: 2019/3/30 21:08
 */

public interface UserAndAspectDAO extends JpaRepository<UserAndAspect, Integer> {
    
    /**
     * @Description: 根据雷达图id查找用户
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 21:21
     */
    List<UserAndAspect> findAllByAspect_AspectId(Integer aspectId);

    /**
     * @Description: 根据用户id查找雷达图
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 21:22
     */
    List<UserAndAspect> findAllByUser_UserId(Integer userId);
}
