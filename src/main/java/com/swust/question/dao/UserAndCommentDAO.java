package com.swust.question.dao;

import com.swust.question.entity.UserAndComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @Description:
 * @Author: yangbin
 * @Time: 2019/4/15 19:26
 */

public interface UserAndCommentDAO extends JpaRepository<UserAndComment, Integer>, PagingAndSortingRepository<UserAndComment, Integer> {
    /**
     * @Description: 根据留言id查找用户
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 21:24
     */
    List<UserAndComment> findAllByComment_CommentId(Integer commentId);

    /**
     * @Description: 根据用户id查找留言
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 21:25
     */
    List<UserAndComment> findAllByUser_UserId(Integer userId);

    /**
     * @Description: 根据用户ID查找用户的留言总数
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 16:52
     */
    long countByUser_UserId(Integer userId);

    /**
     * @Description: 根据用户留言ID查找用户总数
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 16:51
     */
    long countByComment_CommentId(Integer commentId);


    /**
     * @Description: 根据用户ID进行分页查找用户留言列表
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 16:51
     */
    Page<UserAndComment> findAllByUser_UserId(Integer userId, Pageable pageable);

    /**
     * @Description: 根据用户留言ID进行分页查找用户列表
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/13 16:50
     */
    Page<UserAndComment> findAllByComment_CommentId(Integer commentId, Pageable pageable);
}
