package com.ufsmooc.ufsmooc.domain.entities;

import com.ufsmooc.ufsmooc.domain.dto.ModulePartitionDto;
import com.ufsmooc.ufsmooc.domain.entities.partition.Lecture;
import com.ufsmooc.ufsmooc.domain.entities.partition.Questionary;
import com.ufsmooc.ufsmooc.domain.entities.partition.Video;
import com.ufsmooc.ufsmooc.domain.entities.partition.Work;
import com.ufsmooc.ufsmooc.domain.interfaces.IModulePartition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.security.InvalidParameterException;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ModulePartition{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer type;

    @Column
    private Integer sequencePosition;

    @ManyToOne
    private Lecture lecture;


    @ManyToOne
    private Video video;


    @ManyToOne
    private Work work;


    @ManyToOne
    private Questionary questionary;

    public ModulePartition(ModulePartitionDto partitionDto){
        this.name = partitionDto.getName();
        this.type = partitionDto.getType();
        this.sequencePosition = partitionDto.getSequencePosition();
        countNonNullPartition(partitionDto);
            switch (partitionDto.getType()){
                case 0:
                    this.lecture = new Lecture(partitionDto.getLecture());
                    break;
                case 1:
                    this.video = new Video(partitionDto.getVideo());
                    break;
                case 2:
                    this.questionary = new Questionary(partitionDto.getQuestionary());
                    break;
                case 3:
                    this.work = new Work(partitionDto.getWork());
            }
    }

    private void countNonNullPartition(ModulePartitionDto partitionDto){
        int count = 0;
        if (partitionDto.getLecture() != null)
            count++;
        if(partitionDto.getQuestionary() != null)
            count++;
        if(partitionDto.getWork() != null)
            count++;
        if (partitionDto.getVideo() != null)
            count++;
        if (count < 0 || count > 1)
            throw new InvalidParameterException();
    }




}