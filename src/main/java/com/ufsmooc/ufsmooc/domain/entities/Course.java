package com.ufsmooc.ufsmooc.domain.entities;

import com.ufsmooc.ufsmooc.domain.dto.CourseDto;
import com.ufsmooc.ufsmooc.domain.dto.UserDto;
import lombok.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Augusto Pagnossim Frigo
 *
 */


@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40)
    private String name;

    @Column(length = 40)
    private String subtitle;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean hasTutoring;

    @Column(nullable = false)
    private boolean hasCertification;

    @Column
    private Integer numberHours;

    @Column
    private Date beginSubscriptionsDate;

    @Column
    private Date endSubscriptionsDate;

    @Column
    private Date beginCourseDate;

    @Column
    private Date endCourseDate;

    @Column
    private Integer studentsLimit;

    @Column
    private Integer workNotifications;

    @Column
    private Integer questionNotifications;

    @Column
    private Integer forumNotifications;

    @Column
    private Integer doubtNotifications;

    @Column
    private String courseCategory;

    @ManyToMany
    private List<User> students;

    @ManyToMany
    private List<User> teachers;

    @OneToMany
    private List<Module> modules;

    @OneToMany
    private List<Teaches> teaches;


    public Course(CourseDto dto) {
        this.id = id;
        this.name = dto.getTitle();
        this.subtitle = dto.getSubtitle();
        this.description = dto.getDescription();
        this.hasTutoring = dto.getHasTutoring();
        this.hasCertification = dto.getHasCertification();
        this.numberHours = dto.getNumberHours();
        this.beginSubscriptionsDate = dto.getBeginSubscriptionsDate();
        this.endSubscriptionsDate = dto.getEndSubscriptionsDate();
        this.beginCourseDate = dto.getBeginCourseDate();
        this.endCourseDate = dto.getEndCourseDate();
        this.studentsLimit = dto.getStudentsLimit();
        this.workNotifications = 0;
        this.questionNotifications = 0;
        this.forumNotifications = 0;
        this.doubtNotifications = 0;
        this.courseCategory = dto.getCategory();
        this.modules = dto.getModules();
    }


}
