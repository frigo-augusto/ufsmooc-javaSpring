package com.ufsmooc.ufsmooc.domain.dto;

import com.ufsmooc.ufsmooc.domain.entities.Course;
import com.ufsmooc.ufsmooc.domain.entities.ModulePartition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ModuleDto {

    private String title;

    private String path;

    private int position;

    private boolean isAdditional;

    private List<ModulePartitionDto> partitions;

}
