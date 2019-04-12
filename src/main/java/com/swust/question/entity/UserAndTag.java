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

	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private com.swust.question.entity.User user;

	@JoinColumn(name = "tag_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Tag tag;

}
