package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "option")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Option  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "option_id")
	private Integer optionId;

	@Column(name = "option_detial")
	private String optionDetial;

	@Column(name = "option_order")
	private Integer optionOrder;

	@Column(name = "questionn_id")
	private Integer questionnId;

}
