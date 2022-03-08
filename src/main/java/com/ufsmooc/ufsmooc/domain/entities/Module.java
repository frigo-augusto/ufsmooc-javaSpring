package com.ufsmooc.ufsmooc.domain.entities;

import com.ufsmooc.ufsmooc.domain.dto.ModuleDto;
import com.ufsmooc.ufsmooc.domain.dto.partition.evaluable.QuestionaryDto;
import com.ufsmooc.ufsmooc.domain.dto.partition.evaluable.WorkDto;
import com.ufsmooc.ufsmooc.domain.dto.partition.lecture.ContentDto;
import com.ufsmooc.ufsmooc.domain.dto.partition.lecture.PdfDto;
import com.ufsmooc.ufsmooc.domain.dto.partition.lecture.VideoDto;
import com.ufsmooc.ufsmooc.domain.entities.partition.evaluable.Questionary;
import com.ufsmooc.ufsmooc.domain.entities.partition.evaluable.Work;
import com.ufsmooc.ufsmooc.domain.entities.partition.lecture.Content;
import com.ufsmooc.ufsmooc.domain.entities.partition.lecture.Pdf;
import com.ufsmooc.ufsmooc.domain.entities.partition.lecture.Video;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String path;

    @Column
    private int position;

    @Column
    private boolean isAdditional;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<ModulePartition> partitions;


    public Module(ModuleDto moduleDto){
        this.title = moduleDto.getTitle();
        this.path = moduleDto.getPath();
        this.position = moduleDto.getPosition();
        this.isAdditional = isAdditional();
        this.partitions = new ArrayList<>();
        if (moduleDto.getPartitions() != null) {
            for(var partition: moduleDto.getPartitions()){
                switch (partition.getType()) {
                    case 1 -> partitions.add(new Content((ContentDto) partition.getObject()));
                    case 2 -> partitions.add(new Video(((VideoDto) partition.getObject())));
                    case 3 -> partitions.add(new Pdf((PdfDto)partition.getObject()));
                    case 4 -> partitions.add(new Work((WorkDto)partition.getObject()));
                    case 5 -> partitions.add(new Questionary((QuestionaryDto) partition.getObject()));
                }
            }
        }

    }

}
