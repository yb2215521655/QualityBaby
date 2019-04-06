package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "questionnaire")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Questionnaire  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "questionnaire_id")
	@ApiModelProperty("问卷id")
	private Integer questionnaireId;

	@Column(name = "questionnaire_title")
	@ApiModelProperty("问卷名")
	private String questionnaireTitle;

	@Column(name = "questionnaire_instruction")
	@ApiModelProperty("问卷介绍")
	private String questionnaireInstruction;

	@ApiModelProperty(value = "问卷下面的问题",hidden = true)
	@JoinColumn(name = "questionnaire_id")
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Question> questionList;



}

