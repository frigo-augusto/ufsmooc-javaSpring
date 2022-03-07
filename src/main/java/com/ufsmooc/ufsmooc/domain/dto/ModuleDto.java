package com.ufsmooc.ufsmooc.domain.dto;

import com.ufsmooc.ufsmooc.domain.dto.partition.ModulePartitionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
