package com.swust.question.dao;

import com.swust.question.entity.UserAndActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: UserAndActivityDAO
 * @Package com.swust.question.dao
 * @description: 用户-活动对照表
 * @date 2019/3/23 16:07
 */
public interface UserAndActivityDAO extends JpaRepository<UserAndActivity, Integer> {
    /**
     * 根据活动ID查找参加活动的用户列表
     *
     * @param activityId 活动Id
     * @return java.util.List<com.swust.question.entity.UserAndActivity>
     * @author pang
     * @date 2019/3/23
     */
    List<UserAndActivity> findAllByActivity_ActivityId(Integer activityId);
    // List<UserAndActivity> findByActivityId(int activityId);


    /**
     * 根据用户ID查找用户所参加的活动列表
     * @author pang
     * @date 2019/3/23
     * @param  userId 用户ID
     * @return java.util.List<com.swust.question.entity.UserAndActivity>
     */
     List<UserAndActivity> findAllByUser_UserId(Integer userId);
}
