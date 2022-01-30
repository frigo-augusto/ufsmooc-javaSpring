package com.ufsmooc.ufsmooc.domain.repo;

import com.ufsmooc.ufsmooc.domain.entities.Usert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.InvalidParameterException;
import java.util.InvalidPropertiesFormatException;
import java.util.Optional;

public interface UsertRepo extends JpaRepository<Usert, Long> {
    Optional<Usert> findByEmail(String email) throws InvalidParameterException;
}
