package com.ufsmooc.ufsmooc;

import com.ufsmooc.ufsmooc.domain.dto.UserDto;
import com.ufsmooc.ufsmooc.domain.entities.Role;
import com.ufsmooc.ufsmooc.domain.entities.User;
import com.ufsmooc.ufsmooc.service.RoleService;
import com.ufsmooc.ufsmooc.service.UserServiceInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    CommandLineRunner run(UserServiceInterface usertService, RoleService roleService){
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

        };
    }
}
