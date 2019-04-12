package com.swust.question.dao;

import com.swust.question.entity.UserAndActivity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: UserAndActivityDAO
 * @Package com.swust.question.dao
 * @description: 用户-活动对照表
 * @date 2019/3/23 16:07
 */
public interface UserAndActivityDAO extends JpaRepository<UserAndActivity, Integer>, PagingAndSortingRepository<UserAndActivity, Integer> {
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
     *
     * @param userId 用户ID
     * @return java.util.List<com.swust.question.entity.UserAndActivity>
     * @author pang
     * @date 2019/3/23
     */
    List<UserAndActivity> findAllByUser_UserId(Integer userId);

    /**
     * 根据用户ID查找用户所参加的活动总数
     *
     * @param userId 用户ID
     * @return java.lang.Long
     * @author pang
     * @date 2019/4/10
     */
    long countByUser_UserId(Integer userId);

    /**
     * 根据活动ID查找参加活动的用户总数
     *
     * @param activityId
     * @return long
     * @author pang
     * @date 2019/4/10
     */
    long countByActivity_ActivityId(Integer activityId);


    /**
     * 根据用户ID进行分页查找用户所参加的活动列表
     *
     * @param userId   用户ID
     * @param pageable 分页
     * @return java.util.List<com.swust.question.entity.UserAndActivity>
     * @author pang
     * @date 2019/4/10
     */
    Page<UserAndActivity> findAllByUser_UserId(Integer userId, Pageable pageable);


    /**
     * 根据活动ID进行分页查找参加活动的用户列表
     *
     * @param activityId 活动Id
     * @param pageable   分页
     * @return java.util.List<com.swust.question.entity.UserAndActivity>
     * @author pang
     * @date 2019/4/10
     */
    Page<UserAndActivity> findAllByActivity_ActivityId(Integer activityId, Pageable pageable);
}
