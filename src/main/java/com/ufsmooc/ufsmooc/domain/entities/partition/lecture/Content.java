package com.ufsmooc.ufsmooc.domain.entities.partition.lecture;

import com.ufsmooc.ufsmooc.domain.dto.partition.lecture.ContentDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Content extends Lecture{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    public Content(ContentDto content){
        this.content = content.getContent();
    }

}
