package com.ufsmooc.ufsmooc.service;


import com.ufsmooc.ufsmooc.domain.entities.Role;
import com.ufsmooc.ufsmooc.domain.entities.Usert;

import java.util.List;

public interface UsertServiceInterface {
    Usert save(Usert usert);
    void addRole(String email, String roleName);
    Usert findByEmail(String email);
    List<Usert> findAll();
}
