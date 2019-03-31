package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@ApiModel("活动")
@Table(name = "activity")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Activity  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "activity_id")
    @ApiModelProperty("活动Id")
	private Integer activityId;

	@Column(name = "activity_name")
    @ApiModelProperty("活动名")
	private String activityName;

	@Column(name = "activity_information")
    @ApiModelProperty("活动介绍")
	private String activityInformation;

	@Column(name = "activity_start")
    @ApiModelProperty("活动开始时间")
	private java.util.Date activityStart;

	@Column(name = "activity_end")
    @ApiModelProperty("活动结束时间")
	private java.util.Date activityEnd;

	@Column(name = "activity_people_number")
    @ApiModelProperty("活动最大参与人数")
	private Integer activityPeopleNumber;

	@Column(name = "studio_id")
    @ApiModelProperty(value = "活动所属的工作室Id")
	private Integer studioId;

	@Transient
	@ApiModelProperty("活动所属的工作室实体，需要手动进行查找")
    private Studio studio;
}
