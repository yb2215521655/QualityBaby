package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_and_activity")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class UserAndActivity  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "join_time")
	private java.util.Date joinTime;


	@JoinColumn(name = "activity_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Activity activity;

	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private com.swust.question.entity.User user;

}
