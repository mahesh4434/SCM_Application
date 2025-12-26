package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    // user dashboardpage
    @RequestMapping(value = "/dashboard")
    public String userDashBoard() {
        return "user/dashboard";
    }

    // user Profile page
    @RequestMapping(value = "/profile")
    public String userProfile() {
        return "user/profile";
    }
    // user add contact page

    // user view contact

    // user edit contacts

    // user delete contact

}
