package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_and_tag")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class UserAndTag  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "tag_id")
	private Integer tagId;

}
