package com.ufsmooc.ufsmooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/view-teacher-requests")
    public String viewTeacherRequests(){
        //return all teacher requests
        return null;
    }

    @GetMapping("/accept-request")
    public void acceptTeacherRequest(){

    }


}
