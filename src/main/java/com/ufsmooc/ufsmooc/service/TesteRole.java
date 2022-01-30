package com.ufsmooc.ufsmooc.service;

import com.ufsmooc.ufsmooc.domain.entities.Role;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;


@RequiredArgsConstructor
public class TesteRole {

    private static RoleServiceInterface roleService;

    public static Role getStudentRole(){
        return roleService.findByName("STUDENT_ROLE");
    }

}
