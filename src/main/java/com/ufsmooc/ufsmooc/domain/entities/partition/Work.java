package com.ufsmooc.ufsmooc.domain.entities.partition;


import com.ufsmooc.ufsmooc.domain.entities.ModulePartition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Work extends ModulePartition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double weight;

    private String enunciado;

    public Work(double weight, String enunciado) {
        this.weight = weight;
        this.enunciado = enunciado;
    }
}
