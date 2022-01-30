package com.ufsmooc.ufsmooc.service;

import com.ufsmooc.ufsmooc.domain.entities.Role;
import com.ufsmooc.ufsmooc.domain.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.InvalidParameterException;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleService implements RoleServiceInterface{
    private final RoleRepo roleRepo;

    @Override
    public Role save(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public Role findByName(String name) {
        return roleRepo.findByName(name).orElseThrow(() -> new InvalidParameterException());
    }
}
