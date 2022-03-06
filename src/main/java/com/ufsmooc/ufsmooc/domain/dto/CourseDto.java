package com.ufsmooc.ufsmooc.domain.dto;

import com.sun.istack.NotNull;
import com.ufsmooc.ufsmooc.domain.entities.Module;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Validated
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

    @NotNull
    private List<ModuleDto> modules;

    private Integer numberHours;
    private Integer level;

}
