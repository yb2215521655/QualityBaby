package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

//@Data
@Getter
@Setter
@Entity
@Table(name = "aspect_detail")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class AspectDetail implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "detail_id")
	@ApiModelProperty("雷达图维度下小维度id")
	private Integer detailId;

	@Column(name = "detail_name")
	@ApiModelProperty("雷达图维度下小维度名字")
	private String detailName;

	@Column(name = "aspect_id")
	@ApiModelProperty("小维度所属的雷达图大维度id")
	private Integer aspectId;


}
