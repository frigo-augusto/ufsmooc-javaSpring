package com.ufsmooc.ufsmooc.domain.entities.partition.evaluable.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class AlternativeQuestion extends Question{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private Boolean isRight;


}
