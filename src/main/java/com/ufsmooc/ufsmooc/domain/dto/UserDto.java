package com.ufsmooc.ufsmooc.domain.dto;

import lombok.Data;

@Data
public class UserDto {

    String name;
    String surname;
    String cpf;
    String email;
    String uf;
    String city;
    String password;
    String confirmPassword;

    public UserDto(String name, String surname, String cpf, String email, String uf, String city, String password, String confirmPassword){
        this.name = name;
        this.surname = surname;
        this.cpf = cpf;
        this.email = email;
        this.uf = uf;
        this.city = city;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
