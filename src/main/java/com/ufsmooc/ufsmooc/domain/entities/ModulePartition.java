package com.ufsmooc.ufsmooc.domain.entities;

import javax.persistence.*;

@Entity
public class ModulePartition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Character type;

    @Column
    private Integer position;

    @Column
    private String content;



}