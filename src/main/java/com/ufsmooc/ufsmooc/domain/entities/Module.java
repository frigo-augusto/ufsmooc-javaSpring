package com.ufsmooc.ufsmooc.domain.entities;

import com.ufsmooc.ufsmooc.domain.dto.ModuleDto;
import com.ufsmooc.ufsmooc.domain.dto.ModulePartitionDto;
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
            moduleDto.getPartitions().stream()
                    .forEach(partition -> partitions.add(new ModulePartition(partition)));
        }

    }

}
