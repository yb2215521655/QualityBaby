package com.swust.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Entity
@ApiModel("工作室")
@Table(name = "studio")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Studio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studio_id")
    @ApiModelProperty("工作室id")
    private Integer studioId;

    @Column(name = "studio_title")
    @ApiModelProperty("工作室名")
    private String studioTitle;

    @Column(name = "studio_information")
    @ApiModelProperty("工作室介绍")
    private String studioInformation;

    @Column(name = "studio_people_number")
    @ApiModelProperty("工作室最大参与人数")
    private Integer studioPeopleNumber;

    @ApiModelProperty(value = "工作室下面的活动",hidden = true)
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    // @JsonIgnore
    @JoinColumn(name = "studio_id")
    private Set<Activity> activityList;

}
