package com.scm.controllers;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    // user dashboardpage
    @RequestMapping(value = "/dashboard")
    public String userDashBoard() {
        return "user/dashboard";
    }

    // user Profile page
    @RequestMapping(value = "/profile")
    public String userProfile(Principal principal) {
        String name = principal.getName();
        logger.info(name);
        return "user/profile";
    }
    // user add contact page

    // user view contact

    // user edit contacts

    // user delete contact

}
