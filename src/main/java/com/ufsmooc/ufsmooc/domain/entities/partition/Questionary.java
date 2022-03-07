package com.ufsmooc.ufsmooc.domain.entities.partition;

import com.ufsmooc.ufsmooc.domain.dto.partition.QuestionaryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Questionary{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Questionary(QuestionaryDto dto){

    }

}
