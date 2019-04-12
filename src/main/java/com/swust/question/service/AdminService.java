package com.swust.question.service;

import com.google.code.kaptcha.Producer;
import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.common.restful.UnicomRuntimeException;
import com.swust.question.dao.AdminDAO;
import com.swust.question.entity.AdminUser;
import com.swust.question.utils.kaptcha.KaptchaUtil;
import com.swust.question.utils.redis.RedisUtil;
import com.swust.question.utils.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

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
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private Producer producer;
    @Autowired
    private KaptchaUtil kaptchaUtil;

    /**
     * 管理员登录逻辑
     *
     * @param username 用户名
     * @param password 密码
     * @return java.lang.String
     * @author pang
     * @date 2019/4/7
     */
    public String login(String username, String password) {
        AdminUser adminUser = adminDAO.findByAdminLoginName(username);
        if (adminUser == null) {
            return null;
        }
        if (!adminUser.getAdminLoginPassword().equals(password)) {
            return "-1";
        }
        String token = TokenUtil.createJWT(1000 * 60 * 60, username, "administrator");
        redisUtil.set("token_" + username, token, 1000 * 60 * 60);
        return token;
    }

    /**
     * 根据用户名查找管理员信息，用于token拦截器
     *
     * @param username
     * @return com.swust.question.entity.AdminUser
     * @author pang
     * @date 2019/4/7
     */
    public AdminUser findAdminUserByLoginName(String username) {
        return adminDAO.findByAdminLoginName(username);
    }

    /**
     * 获得验证码的base64编码
     *
     * @param
     * @return java.lang.String
     * @author pang
     * @date 2019/4/12
     */
    public String getKaptcha() {
        // 生成验证码内容
        String capText = producer.createText();
        // 获得base64编码
        String encode = null;
        try {
            encode = kaptchaUtil.getKaptcha(capText);
        } catch (IOException e) {
            throw new UnicomRuntimeException(UnicomResponseEnums.SYSTEM_ERROR, "验证码获取失败");
        }
        return encode;
    }
}
