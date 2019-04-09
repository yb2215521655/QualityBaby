package com.swust.question.dao;

import com.swust.question.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pang
 * @version V1.0
 * @ClassName: AdminDAO
 * @Package com.swust.question.dao
 * @description: 管理员相关信息操作
 * @date 2019/4/6 16:56
 */
public interface AdminDAO extends JpaRepository<AdminUser,Integer> {
    /**
     * 根据用户名查找用户
     * @author pang
     * @date 2019/4/6
     * @param loginNmae
     * @return com.swust.question.entity.AdminUser
     */
    AdminUser findByAdminLoginName(String loginNmae);
}
