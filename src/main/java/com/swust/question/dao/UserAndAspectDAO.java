package com.swust.question.dao;

import com.swust.question.entity.UserAndAspect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    /**
     * 根据ID进行分页查找参加活动的用户列表
     *
     * @param aspectId 大维度Id
     * @param pageable   分页
     * @return java.util.List<com.swust.question.entity.UserAndAspect>
     * @author phantaci
     * @date 2019/4/20
     */
    Page<UserAndAspect> findAllByAspect_AspectId(Integer aspectId, Pageable pageable);

    /**
     * 根据用户ID查找用户所设计的雷达图维度的数量
     *
     * @param userId 用户ID
     * @return java.lang.Long
     * @author phantaci
     * @date 2019/4/20
     */
    long countByUser_UserId(Integer userId);
}
