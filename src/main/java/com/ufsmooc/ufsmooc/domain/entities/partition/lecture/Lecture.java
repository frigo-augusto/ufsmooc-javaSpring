package com.ufsmooc.ufsmooc.domain.entities.partition.lecture;

import com.ufsmooc.ufsmooc.domain.entities.ModulePartition;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Lecture extends ModulePartition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
}
