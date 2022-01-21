package com.ufsmooc.ufsmooc.controller;

import com.ufsmooc.ufsmooc.domain.dto.UserDto;
import com.ufsmooc.ufsmooc.domain.entities.UserEntity;
import com.ufsmooc.ufsmooc.domain.interfaces.UserEntityRepository;
import com.ufsmooc.ufsmooc.service.UserService;
import com.ufsmooc.ufsmooc.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserEntityRepository userEntityRepository;

    private UserService userService;

    @RequestMapping(value="/create-user", method = RequestMethod.POST, consumes = "application/JSON")
    public void createUser(@RequestBody UserDto user) throws Exception {
        userService.createUser(user);
    }

    public Optional<UserEntity> findById(){
        Long id = new Long(1);
        return userEntityRepository.findById(id);
    }
}
