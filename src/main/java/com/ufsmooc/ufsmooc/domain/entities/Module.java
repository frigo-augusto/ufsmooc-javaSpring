package com.ufsmooc.ufsmooc.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String path;

    @ManyToOne
    private Course course;

    @Column
    private int position;

    @Column
    private boolean isAdditional;

    @OneToMany
    private List<ModulePartition> partitions;

    public Module(){

    }

}
