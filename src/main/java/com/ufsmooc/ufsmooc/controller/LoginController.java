package com.ufsmooc.ufsmooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/test")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String test(){
        return "Teste bem-sucedido";
    }

}
