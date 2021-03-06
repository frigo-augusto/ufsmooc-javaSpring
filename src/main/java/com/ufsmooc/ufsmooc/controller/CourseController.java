package com.ufsmooc.ufsmooc.controller;

import com.ufsmooc.ufsmooc.domain.dto.CourseDto;
import com.ufsmooc.ufsmooc.domain.entities.Course;
import com.ufsmooc.ufsmooc.domain.entities.Role;
import com.ufsmooc.ufsmooc.domain.repo.CourseRepo;
import com.ufsmooc.ufsmooc.domain.repo.ModulePartitionRepo;
import com.ufsmooc.ufsmooc.domain.repo.ModuleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
@Transactional
public class CourseController {

    private final CourseRepo courseRepo;
    private final ModuleRepo moduleRepo;
    private final ModulePartitionRepo modulePartitionRepo;

    @GetMapping("/save")
    private void courseSave(@RequestBody CourseDto courseDto){
        Course course = new Course(courseDto);
        courseRepo.save(course);
    }

    @GetMapping("/get-all")
    private List getAllCourses(){
        Course course = new Course();
        course.setName("curso teste");
        Role role = new Role();
        role.setName("nome da role");
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

    @GetMapping("/get-all-modulePartition")
    public Object createCourse(@RequestBody CourseDto courseDto){
        Course course = new Course(courseDto);


        System.out.println(courseDto.getTitle());
        System.out.println(courseDto.getModules().get(0).getTitle());
        System.out.println("Nome foda:"+ courseDto.getModules().get(0).getPartitions().get(0).getName());
        //System.out.println(courseDto.getModules().get(0).getPartitions().get(0).getLecture().getContent());

        //System.out.println(course.getModules().get(0).getPartitions().get(0));
        //courseRepo.save(course);

        return null;
    }


}
