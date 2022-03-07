package com.ufsmooc.ufsmooc.domain.dto;

import com.ufsmooc.ufsmooc.domain.dto.partition.LectureDto;
import com.ufsmooc.ufsmooc.domain.dto.partition.QuestionaryDto;
import com.ufsmooc.ufsmooc.domain.dto.partition.VideoDto;
import com.ufsmooc.ufsmooc.domain.dto.partition.WorkDto;
import com.ufsmooc.ufsmooc.domain.entities.partition.Questionary;
import com.ufsmooc.ufsmooc.domain.entities.partition.Video;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModulePartitionDto {

    private String name;
    private Integer type;
    private Integer sequencePosition;
    private LectureDto lecture;
    private VideoDto video;
    private WorkDto work;
    private QuestionaryDto questionary;

    public ModulePartitionDto(String name, Integer type, Integer sequencePosition, LectureDto lecture,
                              VideoDto video, WorkDto work, QuestionaryDto questionary) {
        this.name = name;
        this.type = type;
        this.sequencePosition = sequencePosition;
        this.lecture = lecture;
        this.video = video;
        this.work = work;
        this.questionary = questionary;
    }

}
