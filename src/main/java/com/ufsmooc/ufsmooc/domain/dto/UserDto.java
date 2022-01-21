package com.ufsmooc.ufsmooc.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    String name;
    String surname;
    String cpf;
    String email;
    String UF;
    String city;
    String password;
    String confirmPassword;

}
