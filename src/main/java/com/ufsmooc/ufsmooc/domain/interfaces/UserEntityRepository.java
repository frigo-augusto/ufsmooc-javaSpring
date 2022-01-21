package com.ufsmooc.ufsmooc.domain.interfaces;

import com.ufsmooc.ufsmooc.domain.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findById(Long id);

}
