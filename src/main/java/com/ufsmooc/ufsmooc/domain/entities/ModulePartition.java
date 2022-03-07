package com.ufsmooc.ufsmooc.domain.entities;

import com.ufsmooc.ufsmooc.domain.dto.partition.ModulePartitionDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
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

    public ModulePartition(ModulePartitionDto partitionDto){
        this.name = partitionDto.getName();
        this.type = partitionDto.getType();
        this.sequencePosition = partitionDto.getSequencePosition();
    }




}