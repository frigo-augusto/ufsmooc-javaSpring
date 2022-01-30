package com.ufsmooc.ufsmooc.domain.repo;

import com.ufsmooc.ufsmooc.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String role);
}
