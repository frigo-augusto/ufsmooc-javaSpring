package com.ufsmooc.ufsmooc.domain.dto.partition.evaluable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class QuestionaryDto {

    private String description;

    private String type;

    private Double weight;

    private List<QuestionDto> questions;


}
