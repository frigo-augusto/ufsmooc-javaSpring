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
public class ModulePartitionDto {

    private String name;
    private Integer type;
    private Integer sequencePosition;
    private ContentDto content;
    private PdfDto pdf;
    private VideoDto video;
    private QuestionaryDto questionary;
    private WorkDto work;


    //gambiarra terrivel
    public ModulePartitionDto(String name, Integer type, Integer sequencePosition,
                              ContentDto contentDto, PdfDto pdfDto, VideoDto videoDto,
                              QuestionaryDto questionaryDto, WorkDto workDto) {
        this.name = name;
        this.type = type;
        this.sequencePosition = sequencePosition;
        switch (type){
            case 1 -> this.content = contentDto;
            case 2 -> this.video = videoDto;
            case 3 -> this.pdf = pdfDto;
            case 4 -> this.work = workDto;
            case 5 -> this.questionary = questionaryDto;
        }
    }

}
