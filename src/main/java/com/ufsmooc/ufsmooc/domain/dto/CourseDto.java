package com.ufsmooc.ufsmooc.domain.dto;

import com.ufsmooc.ufsmooc.domain.entities.Module;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CourseDto {

    private String title;
    private String subtitle;
    private String path;
    private String description;
    private Boolean hasTutoring;
    private Boolean hasCertification;
    private Date beginSubscriptionsDate;
    private Date endSubscriptionsDate;
    private Date beginCourseDate;
    private Date endCourseDate;
    private Integer studentsLimit;
    private String category;
    private List<Module> modules;
    private Integer numberHours;
    private Integer level;
}
