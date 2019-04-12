package com.swust.question.dao;

import com.swust.question.entity.UserAndTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description:
 * @Author: yangbin
 * @Time: 2019/3/30 21:22
 */

public interface UserAndTagDAO extends JpaRepository<UserAndTag,Integer> {
    /**
     * @Description: 根据日志id查找用户
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 21:24
     */
    List<UserAndTag> findAllByTag_TagId(Integer tagId);

    /**
     * @Description: 根据用户id查找日志
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 21:25
     */
    List<UserAndTag> findAllByUser_UserId(Integer userId);


}
