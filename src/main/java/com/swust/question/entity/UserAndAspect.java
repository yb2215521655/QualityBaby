package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_and_aspect")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class UserAndAspect  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "aspect_id")
	private Integer aspectId;

	@Column(name = "user_id")
	private Integer userId;

}
