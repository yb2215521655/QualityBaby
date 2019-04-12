package com.swust.question.dao;

import com.swust.question.entity.UserAndStudio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
     *
     * @param userId 用户ID
     * @return java.util.List<com.swust.question.entity.UserAndActivity>
     * @author pang
     * @date 2019/3/23
     */
    List<UserAndStudio> findAllByUser_UserId(Integer userId);

    /**
     * 根据用户ID查找用户所参加的工作室列表(分页)
     *
     * @param userId   用户ID
     * @param pageable 分页
     * @return java.util.List<com.swust.question.entity.UserAndStudio>
     * @author pang
     * @date 2019/4/12
     */
    Page<UserAndStudio> findAllByUser_UserId(Integer userId, Pageable pageable);

    /**
     * 查找用户参加的工作室总数
     *
     * @param userId
     * @return long
     * @author pang
     * @date 2019/4/12
     */
    long countByUser_UserId(Integer userId);

    /**
     * 查找工作室参加的用户总数
     *
     * @param studioId
     * @return long
     * @author pang
     * @date 2019/4/12
     */
    long countByStudio_StudioId(Integer studioId);
}
