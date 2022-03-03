package com.ufsmooc.ufsmooc.controller;

import com.ufsmooc.ufsmooc.domain.dto.CourseDto;
import com.ufsmooc.ufsmooc.domain.entities.Course;
import com.ufsmooc.ufsmooc.domain.entities.Role;
import com.ufsmooc.ufsmooc.domain.repo.CourseRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseRepo courseRepo;

    @GetMapping("/save")
    private void courseSave(@RequestBody CourseDto courseDto){
        Course course = new Course(courseDto);
        courseRepo.save(course);
    }

    @GetMapping("/get-all")
    private List<Course> getAllCourses(){
        Course course = new Course();
        Role role = new Role();
        List<Object> list = new ArrayList<>();
        list.add(course);
        list.add(role);

        Role newRole = null;
        Role newRole2 = null;
        if (list.get(0) instanceof Role){
            newRole = (Role) list.get(0);
        }
        if (list.get(1) instanceof Role){
            newRole2 = (Role) list.get(1);
        }
        System.out.println(newRole);
        System.out.println(newRole2);
        System.out.println(list);



        return courseRepo.findAll();
    }


}
