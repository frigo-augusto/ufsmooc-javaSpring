package com.ufsmooc.ufsmooc.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40)
    private String courseName;

    @Column(length = 40)
    private String courseSubtitle;

    @Column(nullable = false)
    private String courseDescription;

    @Column(nullable = false)
    private boolean hasTutoring;

    @Column(nullable = false)
    private boolean hasCertification;

    @Column
    private boolean numberHours;

    @Column
    private Calendar beginSubscriptionsDate;

    @Column
    private Calendar endSubscriptionsDate;

    @Column
    private Calendar beginCourseDate;

    @Column
    private Calendar endCourseDate;

    @Column
    private int studentsLimit;

    @Column
    private int workNotifications;

    @Column
    private int questionNotifications;

    @Column
    private int forumNotifications;

    @Column
    private int doubtNotifications;

    @Column
    private int courseCategory;


}
