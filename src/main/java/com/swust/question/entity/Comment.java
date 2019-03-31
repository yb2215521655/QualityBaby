package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "comment")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Comment  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private Integer commentId;

	@Column(name = "comment_time")
	private java.util.Date commentTime;

	@Column(name = "comment_detial")
	private String commentDetial;

	@Column(name = "comment_like")
	private Integer commentLike;

	@Column(name = "comment_sender")
	private Integer commentSender;

}
