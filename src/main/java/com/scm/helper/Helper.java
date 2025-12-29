package com.scm.helper;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.core.userdetails.UserDetails;

public class Helper {

    public static String getEmailOfLoggedInUser(Authentication authentication) {

        // 1. Check if the user is logged in via OAuth2 (Google, GitHub, etc.)
        if (authentication instanceof OAuth2AuthenticationToken) {

            var oAuth2Token = (OAuth2AuthenticationToken) authentication;
            var clientId = oAuth2Token.getAuthorizedClientRegistrationId();
            var oAuth2User = (DefaultOAuth2User) authentication.getPrincipal();

            String email = "";

            if (clientId.equalsIgnoreCase("google")) {
                System.out.println("Getting email from Google");
                email = oAuth2User.getAttribute("email");

            } else if (clientId.equalsIgnoreCase("github")) {
                System.out.println("Getting email from GitHub");
                // GitHub might have email as "email" or you might need to handle
                // cases where the email is private (requires extra API calls)
                email = oAuth2User.getAttribute("email") != null ? oAuth2User.getAttribute("email").toString()
                        : oAuth2User.getAttribute("login").toString() + "@github.com";
            }

            return email;
        }

        // 2. Check if the user is logged in via Local Database (Form Login)
        else {
            System.out.println("Getting data from Local Database");
            return authentication.getName();
        }
    }
}