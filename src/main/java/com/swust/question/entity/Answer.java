package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "answer")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Answer  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "answer_id")
	@ApiModelProperty("回答id")
	private Integer answerId;

	@Column(name = "answer_time")
	@ApiModelProperty("回答时间")
	private java.util.Date answerTime;

	@Column(name = "option_id")
	@ApiModelProperty("选项id")
	private Integer optionId;

	@Column(name = "user_id")
	@ApiModelProperty("用户id")
	private Integer userId;


//	@ApiModelProperty(value = "用户的答案",hidden = true)
//	@JoinColumn(name = "answer_id")
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//	private Answer answer;

//	@ApiModelProperty(value = "回答该答案的用户",hidden = true)
//	@JoinColumn(name = "user_id")
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//	private User user ;
}
