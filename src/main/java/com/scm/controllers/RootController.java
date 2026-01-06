package com.scm.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.scm.entities.User;
import com.scm.helper.Helper;
import com.scm.services.UserService;

@ControllerAdvice
public class RootController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    // Ya madhlya method att each request sathi execute hotil!

    @ModelAttribute
    public void addLoggedInUserInformation(Model model, Authentication authentication) {
        if (authentication == null) {
            return;
        }

        System.out.println("Adding logged in user information to the model!!");
        String userName = Helper.getEmailOfLoggedInUser(authentication);
        logger.info("User logged in :{}", userName);

        // 1. Get the Optional from the service
        Optional<User> userOptional = userService.getUserByEmail(userName);

        // 2. Safely unwrap the user (throws an exception if user is not found)
        User user = userOptional.orElse(null);

        // 3. Now you can access the methods
        System.out.println(user);
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        model.addAttribute("loggedInUser", user);
    }

}
