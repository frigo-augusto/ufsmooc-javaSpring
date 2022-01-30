package com.ufsmooc.ufsmooc.controller;

import com.ufsmooc.ufsmooc.domain.dto.UserDto;
import com.ufsmooc.ufsmooc.domain.entities.Usert;
import com.ufsmooc.ufsmooc.domain.repo.UsertRepo;
import com.ufsmooc.ufsmooc.service.RoleService;
import com.ufsmooc.ufsmooc.service.RoleServiceInterface;
import com.ufsmooc.ufsmooc.service.UsertService;
import com.ufsmooc.ufsmooc.service.UsertServiceInterface;
import com.ufsmooc.ufsmooc.util.SecurityUtil;
import com.ufsmooc.ufsmooc.util.UserUtil;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController @RequiredArgsConstructor
public class UsertController {

    private final UsertServiceInterface usertService;
    private final RoleServiceInterface roleService;

    @RequestMapping(value="/create-user", method = RequestMethod.POST, consumes = "application/JSON")
    public String createUser(@RequestBody UserDto user) throws Exception{
        System.out.println(user);
        if (!user.getPassword().equals(user.getConfirmPassword()) || !UserUtil.isCpfValid(user.getCpf()))
            throw new InvalidParameterException();
        try{
            Usert userEntity = new Usert(user, roleService.findByName("ROLE_STUDENT"));
            usertService.save(userEntity);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new SQLException();
        }
        System.out.println(usertService.findByEmail(user.getEmail()));
        return usertService.findAll().toString();
    }

    @RequestMapping(value="/get-users", method = RequestMethod.GET)
    public String getUsers(){
        return usertService.findAll().toString();
    }
}
