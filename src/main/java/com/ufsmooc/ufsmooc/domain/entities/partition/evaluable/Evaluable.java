package com.ufsmooc.ufsmooc.domain.entities.partition.evaluable;


import com.ufsmooc.ufsmooc.domain.entities.ModulePartition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Evaluable extends ModulePartition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double weight;
}
