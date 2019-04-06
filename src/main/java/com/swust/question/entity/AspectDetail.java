package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "aspect_detail")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class AspectDetail implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "detail_id")
	private Integer detailId;

	@Column(name = "detail_name")
	private String detailName;

	@Column(name = "aspect_id")
	private Integer aspectId;

}
