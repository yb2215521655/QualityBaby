package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_options")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Option  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "option_id")
	@ApiModelProperty("选项id")
	private Integer optionId;

	@Column(name = "option_detail")
	@ApiModelProperty("选项内容")
	private String optionDetail;

	@Column(name = "option_order")
	@ApiModelProperty("选项顺序")
	private Integer optionOrder;

	@Column(name = "question_id")
	@ApiModelProperty("所属问题的id")
	private Integer questionId;

//	@JoinColumn(name = "option_id")
//	//@ManyToOne(fetch = FetchType.EAGER)
//	private int optionId;
}
