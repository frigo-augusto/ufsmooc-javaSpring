package com.ufsmooc.ufsmooc.domain.dto.partition.evaluable.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class AlternativeQuestionDto {

    private String content;
    boolean isRight;

}
