package com.ufsmooc.ufsmooc.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    String name;
    String surname;
    String cpf;
    String email;
    String uf;
    String city;
    String password;
    String confirmPassword;

}
