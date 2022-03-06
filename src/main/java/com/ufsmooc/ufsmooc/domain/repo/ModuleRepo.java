package com.ufsmooc.ufsmooc.domain.repo;

import com.ufsmooc.ufsmooc.domain.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepo extends JpaRepository<Module, Long> {

}
