package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "stu_id")
	private Integer stuId;

	@Column(name = "open_id")
	private String openId;

	@Column(name = "tell_number")
	private String tellNumber;

	@Column(name = "class_name")
	private String className;

	@Column(name = "user_gender")
	private Boolean userGender;

}
