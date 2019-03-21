package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
	private Integer answerId;

	@Column(name = "answer_time")
	private java.util.Date answerTime;

	@Column(name = "option_id")
	private Integer optionId;

	@Column(name = "user_id")
	private Integer userId;

}
