package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "studio")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Studio  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "studio_id")
	private Integer studioId;

	@Column(name = "studio_title")
	private String studioTitle;

	@Column(name = "studio_information")
	private String studioInformation;

	@Column(name = "studio_people_number")
	private Integer studioPeopleNumber;

}
