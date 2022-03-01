package com.ufsmooc.ufsmooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/admin")
public class AdminController {

    @GetMapping("/batata")
    public String getText(){
        return "batata";
    }

}
