package com.swust.question.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description:
 * @Author: yangbin
 * @Time: 2019/4/15 19:22
 */

@Data
@Entity
@Table(name = "user_and_comment")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class UserAndComment  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "comment_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Comment comment;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private com.swust.question.entity.User user;

}
