package com.ufsmooc.ufsmooc.service;

import com.ufsmooc.ufsmooc.domain.entities.Role;

public interface RoleServiceInterface {
    Role save(Role role);
    Role findByName(String name);
}
