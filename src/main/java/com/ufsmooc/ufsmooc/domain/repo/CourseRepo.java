package com.ufsmooc.ufsmooc.domain.repo;

import com.ufsmooc.ufsmooc.domain.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Long> {
    Optional<Course> findByName(String name);
}
