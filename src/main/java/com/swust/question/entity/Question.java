package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "question")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Question  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "question_id")
	@ApiModelProperty("问题id")
	private Integer questionId;

	@Column(name = "question_detail")
	@ApiModelProperty("问题内容")
	private String questionDetail;

	@Column(name = "questionnaire_id")
	@ApiModelProperty("问题所属问卷id")
	private Integer questionnaireId;

//	@JoinColumn(name = "question_id")
//	//@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//	@ManyToOne(fetch = FetchType.EAGER)
//	private Questionnaire questionnaire;

//	@ApiModelProperty(value = "问题下面的选项",hidden = true)
//	@JoinColumn(name = "question_id")
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//	private Set<Option> optionList;

}
