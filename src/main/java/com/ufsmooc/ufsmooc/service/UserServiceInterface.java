package com.ufsmooc.ufsmooc.service;


import com.ufsmooc.ufsmooc.domain.entities.User;

import java.util.List;

public interface UserServiceInterface {
    User save(User user);
    void addRole(String email, String roleName);
    User findByEmail(String email);
    List<User> findAll();
}
