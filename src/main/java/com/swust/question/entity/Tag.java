package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tag")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Tag  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "tag_id")
	private Integer tagId;

	@Column(name = "tag_name")
	private String tagName;

}
