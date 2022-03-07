package com.ufsmooc.ufsmooc.domain.dto.partition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModulePartitionDto<T> {

    private String name;
    private Integer type;
    private Integer sequencePosition;
    private T content;

    public ModulePartitionDto(String name, Integer type, Integer sequencePosition, T content) {
        this.name = name;
        this.type = type;
        this.sequencePosition = sequencePosition;
        this.content = content;
    }

}
