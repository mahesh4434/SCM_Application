package com.scm.controllers;

import java.security.Principal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.User;
import com.scm.helper.Helper;
import com.scm.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // user dashboardpage
    @RequestMapping(value = "/dashboard")
    public String userDashBoard() {
        return "user/dashboard";
    }

    // user Profile page
    @RequestMapping(value = "/profile")
    public String userProfile(Model model, Authentication authentication) {
        String userName = Helper.getEmailOfLoggedInUser(authentication);
        logger.info("User logged in :{}", userName);

        // 1. Get the Optional from the service
        Optional<User> userOptional = userService.getUserByEmail(userName);

        // 2. Safely unwrap the user (throws an exception if user is not found)
        User user = userOptional.orElseThrow(() -> new RuntimeException("User not found with email: " + userName));

        // 3. Now you can access the methods
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        model.addAttribute("loggedInUser", user);
        return "user/profile";
    }
    // user add contact page

    // user view contact

    // user edit contacts

    // user delete contact

}
