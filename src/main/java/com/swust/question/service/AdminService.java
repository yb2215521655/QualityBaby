package com.swust.question.service;

import com.swust.question.dao.AdminDAO;
import com.swust.question.entity.AdminUser;
import com.swust.question.utils.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pang
 * @version V1.0
 * @ClassName: AdminService
 * @Package com.swust.question.service
 * @description: 管理员事务层
 * @date 2019/4/6 16:57
 */
@Service
public class AdminService {
    @Autowired
    private AdminDAO adminDAO;

    /**
     * 管理员登录逻辑
     * @author pang
     * @date 2019/4/7
     * @param username 用户名
     * @param password 密码
     * @return java.lang.String
     */
    public String login(String username,String password){
        AdminUser adminUser=adminDAO.findByAdminLoginName(username);
        if (adminUser==null){
            return null;
        }
        if (!adminUser.getAdminLoginPassword().equals(password)){
            return "-1";
        }
        String token= TokenUtil.createJWT(1000*60*60,username,"administrator");
        return token;
    }

    /**
     * 根据用户名查找管理员信息，用于token拦截器
     * @author pang
     * @date 2019/4/7
     * @param username
     * @return com.swust.question.entity.AdminUser
     */
    public AdminUser findAdminUserByLoginName(String username){
        return adminDAO.findByAdminLoginName(username);
    }
}
