package com.ufsmooc.ufsmooc;

import com.ufsmooc.ufsmooc.domain.dto.CourseDto;
import com.ufsmooc.ufsmooc.domain.dto.UserDto;
import com.ufsmooc.ufsmooc.domain.entities.Course;
import com.ufsmooc.ufsmooc.domain.entities.Role;
import com.ufsmooc.ufsmooc.domain.entities.User;
import com.ufsmooc.ufsmooc.domain.repo.*;
import com.ufsmooc.ufsmooc.service.RoleService;
import com.ufsmooc.ufsmooc.service.UserServiceInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class UfsmoocApplication {

    public static void main(String[] args) {
        SpringApplication.run(UfsmoocApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserServiceInterface usertService, RoleService roleService,
                          CourseRepo courseRepo,
                          ModulePartitionRepo modulePartitionRepo,
                          LectureRepo lectureRepo, VideoRepo videoRepo){
        return args -> {

            roleService.save(new Role("ROLE_STUDENT"));
            roleService.save(new Role("ROLE_TEACHER"));
            roleService.save(new Role("ROLE_ADMIN"));

            usertService.save(new User(new UserDto("student", "da silva", "22222222222", "student@gmail.com",
                    "RS", "santa maria", "123", null), null));
            usertService.save(new User(new UserDto("teacher", "da silva", "33333333333", "teacher@gmail.com",
                    "SP", "santa maria", "123", null), null));
            usertService.save(new User(new UserDto("admin", "da silva", "44444444444", "admin@gmail.com",
                    "SP", "santa maria", "123", null), null));

            usertService.addRole("student@gmail.com", "ROLE_STUDENT");
            usertService.addRole("teacher@gmail.com", "ROLE_TEACHER");
            usertService.addRole("admin@gmail.com", "ROLE_ADMIN");

            courseRepo.save(new Course(new CourseDto("curso teste", "subtitulo epico", "null", "descricao",
                    false, false, new Date(2002, 17, 9), new Date(2002, 18, 9),
                    new Date(2002, 19, 9), new Date(2002, 20, 9), 20, "a", null, 20, 2)));

            courseRepo.save(new Course(new CourseDto("curso teste 2", "subtitulo epico 2", null, "descricao sem criatividade",
                    false, false, new Date(2002, 17, 9), new Date(2002, 18, 9),
                    new Date(2002, 19, 9), new Date(2002, 20, 9), 20, "a", null, 20, 2)));

            /*moduleRepo.save(new Module());
            Module a = moduleRepo.findById(Long.getLong(String.valueOf(1))).orElseThrow(NullPointerException :: new).
            lectureRepo.save(new Lecture("aprendizado foda"));
            videoRepo.save(new Video());
            lectureRepo.save(new Lecture("aprendizado foda que fica no 3"));*/

        };
    }
}
