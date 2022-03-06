package com.ufsmooc.ufsmooc.domain.entities;

import com.ufsmooc.ufsmooc.domain.entities.partition.Questionary;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Teaches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;

    @OneToMany
    private List<Assessment> assessments;

    @Entity
    @Getter
    @Setter
    @EqualsAndHashCode
    public static class Assessment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        private Teaches teaches;

        @ManyToOne
        private Questionary questionary;

        private double grade;
        private double weight;

        private String comment;
    }
}
