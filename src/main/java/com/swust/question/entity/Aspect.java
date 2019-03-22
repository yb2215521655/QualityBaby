package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "aspect")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Aspect  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "aspect_id")
	private Integer aspectId;

	@Column(name = "aspect_name")
	private String aspectName;

}
