package com.ufsmooc.ufsmooc.domain.repo;

import com.ufsmooc.ufsmooc.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.InvalidParameterException;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email) throws InvalidParameterException;
}
