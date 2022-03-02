package com.ufsmooc.ufsmooc.domain.entities;


import com.ufsmooc.ufsmooc.domain.dto.UserDto;
import com.ufsmooc.ufsmooc.util.SecurityUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class User {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    @OneToMany
    private List<Course> subscribedCourses;

    public User(UserDto user, Role role) {
        this.name = user.getName();
        this.surname = user.getSurname();
        this.cpf = user.getCpf();
        this.email = user.getEmail();
        this.uf = user.getUf();
        this.city = user.getCity();
        this.password = SecurityUtil.encryptPassword(user.getPassword());
        this.role = role;
    }

    public User() {

    }
}
