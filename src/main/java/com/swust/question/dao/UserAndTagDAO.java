package com.swust.question.dao;

import com.swust.question.entity.UserAndActivity;
import com.swust.question.entity.UserAndTag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    /**
     * @Description: 根据用户ID查找用户的日志总数
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 16:52
     */
    long countByUser_UserId(Integer userId);

    /**
     * @Description: 根据用户日志ID查找用户总数
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 16:51
     */
    long countByTag_TagId(Integer tagId);


    /**
     * @Description: 根据用户ID进行分页查找用户日志列表
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/4/13 16:51
     */
    Page<UserAndTag> findAllByUser_UserId(Integer userId, Pageable pageable);

    /**
     * @Description: 根据用户日志ID进行分页查找用户列表
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/4/13 16:50
     */
    Page<UserAndTag> findAllByTag_TagId(Integer tagId, Pageable pageable);
}
