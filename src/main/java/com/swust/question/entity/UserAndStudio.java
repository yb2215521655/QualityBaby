package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_and_studio")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class UserAndStudio  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "join_time")
	private java.util.Date joinTime;

	@JoinColumn(name = "studio_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Studio studio;

	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private com.swust.question.entity.User user;

}
