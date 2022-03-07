package com.ufsmooc.ufsmooc.domain.dto.partition.evaluable;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuestionDto<T> {

    private Integer type;
    private String text;
    private List<T> questionsDto;


}
