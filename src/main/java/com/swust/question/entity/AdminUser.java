package com.swust.question.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * @author pang
 * @version V1.0
 * @ClassName: AdminUser
 * @Package com.swust.question.entity
 * @description: 管理员实体类
 * @date 2019/4/6 16:53
 */
@Entity
@Data
@Table(name = "admin_user")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer adminId;

    @Column(name = "admin_real_name")
    private String adminRealName;

    @Column(name = "admin_login_name")
    private String adminLoginName;

    @Column(name = "admin_login_password")
    private String adminLoginPassword;

}
