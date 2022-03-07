package com.ufsmooc.ufsmooc.domain.entities.partition.evaluable;


import com.ufsmooc.ufsmooc.domain.dto.partition.evaluable.WorkDto;
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
public class Work extends Evaluable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double weight;

    private String enunciado;

    public Work(double weight, String enunciado) {
        this.weight = weight;
        this.enunciado = enunciado;
    }

    public Work(WorkDto dto){

    }
}
