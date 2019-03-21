package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "questionnaire")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Questionnaire  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "questionnaire_id")
	private Integer questionnaireId;

	@Column(name = "questionnaire_title")
	private String questionnaireTitle;

	@Column(name = "questionnaire_instruction")
	private String questionnaireInstruction;

}
