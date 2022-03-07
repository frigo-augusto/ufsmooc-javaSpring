package com.ufsmooc.ufsmooc.domain.entities.partition.lecture;

import com.ufsmooc.ufsmooc.domain.dto.partition.lecture.VideoDto;
import com.ufsmooc.ufsmooc.domain.entities.partition.lecture.Lecture;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Video extends Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String link;

    public Video(VideoDto videoDto){
        this.description = videoDto.getDescription();
        this.link = videoDto.getLink();
    }

}
