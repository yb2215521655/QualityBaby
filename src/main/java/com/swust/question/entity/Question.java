package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "question")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Question  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "question_id")
	private Integer questionId;

	@Column(name = "question_detial")
	private String questionDetial;

	@Column(name = "questionnaire_id")
	private Integer questionnaireId;

}
