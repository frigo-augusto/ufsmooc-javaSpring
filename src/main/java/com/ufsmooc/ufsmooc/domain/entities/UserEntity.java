package com.ufsmooc.ufsmooc.domain.entities;


import lombok.Cleanup;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
public class UserEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public UserEntity( String name) { //n pode criar table chamada user

    }

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String uf;

    @Column(nullable = false)
    private String city;

    @Column(length = 127, nullable = false)
    private String password;

    @Column(length = 11, unique = true, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private int typeUser;


    public UserEntity() {
        this.name = "a";
    }
}
