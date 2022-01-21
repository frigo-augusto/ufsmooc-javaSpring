package com.ufsmooc.ufsmooc.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode
public class Usera {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Usera(Integer id, String name) { //n pode criar table chamada user
        this.id = id;
        this.name = name;
    }

    private String name;


    public Usera() {
        this.id = 0;
        this.name = "a";
    }
}
