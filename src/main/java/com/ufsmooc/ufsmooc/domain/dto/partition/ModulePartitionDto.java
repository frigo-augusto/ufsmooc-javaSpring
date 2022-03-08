package com.ufsmooc.ufsmooc.domain.dto.partition;

import com.ufsmooc.ufsmooc.domain.dto.CourseDto;
import com.ufsmooc.ufsmooc.domain.dto.partition.evaluable.QuestionaryDto;
import com.ufsmooc.ufsmooc.domain.dto.partition.evaluable.WorkDto;
import com.ufsmooc.ufsmooc.domain.dto.partition.lecture.ContentDto;
import com.ufsmooc.ufsmooc.domain.dto.partition.lecture.PdfDto;
import com.ufsmooc.ufsmooc.domain.dto.partition.lecture.VideoDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModulePartitionDto<T> {

    private String name;
    private Integer type;
    private Integer sequencePosition;
    private Object object;


    public ModulePartitionDto(String name, Integer type, Integer sequencePosition,
                              ContentDto content, PdfDto pdf, VideoDto video,
                              QuestionaryDto questionary, WorkDto work) {
        this.name = name;
        this.type = type;
        this.sequencePosition = sequencePosition;
        switch (type){
            case 1 -> this.object = content;
            case 2 -> this.object = video;
            case 3 -> this.object = pdf;
            case 4 -> this.object = work;
            case 5 -> this.object = questionary;
        }
    }

}
