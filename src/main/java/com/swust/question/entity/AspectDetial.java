package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "aspect_detial")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class AspectDetial  implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "detial_id")
	private Integer detialId;

	@Column(name = "detiat_name")
	private String detiatName;

	@Column(name = "aspect_id")
	private Integer aspectId;

}
