package com.ufsmooc.ufsmooc.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;


@RestController
public class LoginController {

    @RequestMapping(value="/test", method= RequestMethod.GET)
    public String test(){
        throw new InvalidParameterException();
    }

}
