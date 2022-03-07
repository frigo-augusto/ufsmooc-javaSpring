package com.ufsmooc.ufsmooc.domain.entities.partition.evaluable.question;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @Column
    private Integer type;

}
