package com.swust.question.dao;

import com.swust.question.entity.UserAndStudio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: UserAndStudioDAO
 * @Package com.swust.question.dao
 * @description: 用户-工作室关联表
 * @date 2019/3/23 17:46
 */
public interface UserAndStudioDAO extends JpaRepository<UserAndStudio, Integer> {
    /**
     * 根据活动ID查找参加工作室的用户列表
     *
     * @param studioId 活动Id
     * @return java.util.List<com.swust.question.entity.UserAndActivity>
     * @author pang
     * @date 2019/3/23
     */
    List<UserAndStudio> findAllByStudio_StudioId(Integer studioId);


    /**
     * 根据用户ID查找用户所参加的工作室列表
     * @author pang
     * @date 2019/3/23
     * @param  userId 用户ID
     * @return java.util.List<com.swust.question.entity.UserAndActivity>
     */
    List<UserAndStudio> findAllByUser_UserId(Integer userId);
}
