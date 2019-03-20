package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "activity")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Activity  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "activity_id")
	private Integer activityId;

	@Column(name = "activity_name")
	private String activityName;

	@Column(name = "activity_information")
	private String activityInformation;

	@Column(name = "activity_start")
	private java.util.Date activityStart;

	@Column(name = "activity_end")
	private java.util.Date activityEnd;

	@Column(name = "activity_people_number")
	private Integer activityPeopleNumber;

	@Column(name = "studio_id")
	private Integer studioId;

}
