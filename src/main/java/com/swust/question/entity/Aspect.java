package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.List;

//@Data
@Getter
@Setter
@Entity
@Table(name = "aspect")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Aspect  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "aspect_id")
	@ApiModelProperty("雷达图维度分量id")
	private Integer aspectId;

	@Column(name = "aspect_name")
	@ApiModelProperty("雷达图维度分量名字")
	private String aspectName;

	@ApiModelProperty(value = "大维度下面的小维度",hidden = true)
	@JoinColumn(name = "aspect_id")
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	//@OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	private Set<AspectDetail> detailList;


}
