package com.ufsmooc.ufsmooc.service;

import com.ufsmooc.ufsmooc.domain.dto.UserDto;
import com.ufsmooc.ufsmooc.domain.entities.UserEntity;
import com.ufsmooc.ufsmooc.domain.interfaces.UserEntityRepository;
import com.ufsmooc.ufsmooc.util.SecurityUtil;
import com.ufsmooc.ufsmooc.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.InvalidParameterException;
import java.sql.SQLException;

public class UserService {

    @Autowired
    UserEntityRepository userEntityRepository;

    public void createUser(UserDto user) throws Exception{
        if (!user.getPassword().equals(user.getConfirmPassword()) || !UserUtil.isCpfValid(user.getCpf()))
            throw new InvalidParameterException();
        try{
            UserEntity userEntity = new UserEntity();
            userEntity.setTypeUser(0);
            userEntity.setCpf(user.getCpf());
            userEntity.setName(user.getName());
            userEntity.setPassword(SecurityUtil.encryptPassword().encode(user.getPassword()));
            userEntityRepository.save(userEntity);
        }
        catch (Exception e){
            throw new SQLException();
        }
    }
}
